// Login Controller
package org.rplbo.app.ug8.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import org.rplbo.app.ug8.UmbrellaApp;
import org.rplbo.app.ug8.UmbrellaDBManager;

public class LoginController {
    @FXML private TextField txtUsername;
    @FXML private PasswordField txtPassword;
    @FXML private Label lblStatus;

    @FXML
    private void handleLogin(ActionEvent event) {
        // ==============================================================================
        // TODO 1: PROSES AUTENTIKASI (LOGIN)
        // ==============================================================================
        // 1. Ambil input teks dari txtUsername dan txtPassword.
        // 2. Buat instansiasi dari class UmbrellaDBManager.
        // 3. Panggil metode validateUser() dari db manager tersebut.
        // 4. Jika hasil validasi berhasil (tidak null):
        //    a. Simpan nama user ke variabel statis UmbrellaApp.loggedInUser.
        //    b. Pindah ke halaman "umbrella-view.fxml" menggunakan UmbrellaApp.switchScene().
        // 5. Jika gagal, tampilkan pesan error "AUTHENTICATION FAILED" pada lblStatus.
        // ==============================================================================

        // --- TULIS KODE ANDA DI BAWAH INI ---
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        UmbrellaDBManager dbManager = new UmbrellaDBManager();
        String result = dbManager.validateUser(username, password);
        if (result != null) {
            try {
                UmbrellaApp.loggedInUser = result;
                UmbrellaApp.switchScene("umbrella-view.fxml");
            } catch (Exception e) {
                e.printStackTrace();
                lblStatus.setText("ERROR LOADING PAGE");
            }
        }
        else {
            lblStatus.setText("AUTHENTICATION FAILED");
        }
    }
}
