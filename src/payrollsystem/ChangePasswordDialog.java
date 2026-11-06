package payrollsystem;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

// Control 1: users still on their initial password must set a new one before any portal opens.
final class ChangePasswordDialog extends JDialog {
    static final int MIN_LENGTH = PasswordPolicy.MIN_LENGTH;

    private final JPasswordField txtNewPassword = new JPasswordField(20);
    private final JPasswordField txtConfirmPassword = new JPasswordField(20);
    private final Login login;
    private final String currentPassword;
    private boolean changed = false;

    private ChangePasswordDialog(Frame owner, Login login, String currentPassword){
        super(owner, "Change Your Password", true);
        this.login = login;
        this.currentPassword = currentPassword;
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // the X button does nothing; Cancel aborts the login

        JPanel form = new JPanel(new GridLayout(0, 1, 4, 4));
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        form.add(new JLabel("You are still using your initial password. Please set a new one."));
        form.add(new JLabel("New Password:"));
        form.add(txtNewPassword);
        form.add(new JLabel("Confirm Password:"));
        form.add(txtConfirmPassword);

        JButton btnSetPassword = new JButton("Set Password");
        JButton btnCancel = new JButton("Cancel");
        btnSetPassword.addActionListener(e -> setPassword());
        btnCancel.addActionListener(e -> dispose());
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttons.add(btnCancel);
        buttons.add(btnSetPassword);

        add(form, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(btnSetPassword);
        pack();
        setLocationRelativeTo(owner);
    }

    // Shows the dialog and waits; returns true only if a new password was saved.
    static boolean prompt(Frame owner, Login login, String currentPassword){
        ChangePasswordDialog dialog = new ChangePasswordDialog(owner, login, currentPassword);
        dialog.setVisible(true);
        return dialog.changed;
    }

    private void setPassword(){
        String newPassword = new String(txtNewPassword.getPassword());
        String confirmPassword = new String(txtConfirmPassword.getPassword());
        String error = checkNewPassword(newPassword, confirmPassword, currentPassword, String.valueOf(login.getEmployeeID()));
        if(error != null){
            JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(login.changePassword(newPassword)){
            changed = true;
            SecurityLog.event("PASSWORD_CHANGED", String.valueOf(login.getEmployeeID()), "forced first-login change");
            JOptionPane.showMessageDialog(this, "Password changed successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }else{
            JOptionPane.showMessageDialog(this, "Could not save the new password. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Returns an error message, or null when the new password is acceptable.
    static String checkNewPassword(String newPassword, String confirmPassword, String currentPassword, String employeeID){
        if(newPassword.isEmpty() || confirmPassword.isEmpty()){
            return "Please fill in both password fields.";
        }
        String error = PasswordPolicy.check(newPassword, employeeID, currentPassword); // shared rules (Control 1)
        if(error != null){
            return error;
        }
        if(!newPassword.equals(confirmPassword)){
            return "Passwords do not match.";
        }
        return null;
    }
}