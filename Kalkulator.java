package com.rplbo.kalkulatorbesar;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Arrays;

public class Kalkulator {
    StringBuilder angkas = new StringBuilder();

    @FXML
    Label jawaban;

    @FXML
    TextField inputan;


    public void updateIsi() {
        inputan.setText(angkas.toString());
    }

// --- Tombol Angka ---

    public void angka0() {
        angkas.append("0");
        updateIsi();
    }

    public void angka1() {
        angkas.append("1");
        updateIsi();
    }

    public void angka2() {
        angkas.append("2");
        updateIsi();
    }

    public void angka3() {
        angkas.append("3");
        updateIsi();
    }

    public void angka4() {
        angkas.append("4");
        updateIsi();
    }

    public void angka5() {
        angkas.append("5");
        updateIsi();
    }

    public void angka6() {
        angkas.append("6");
        updateIsi();
    }

    public void angka7() {
        angkas.append("7");
        updateIsi();
    }

    public void angka8() {
        angkas.append("8");
        updateIsi();
    }

    public void angka9() {
        angkas.append("9");
        updateIsi();
    }

    public void tambah() {
        angkas.append(" + ");
        updateIsi();
    }

    public void kurang() {
        angkas.append(" - ");
        updateIsi();
    }

    public void kali() {
        angkas.append(" * ");
        updateIsi();
    }

    public void bagi() {
        angkas.append(" / ");
        updateIsi();
    }

    public void hitung() {
        String ekspresi = angkas.toString().trim();
        if (ekspresi.isEmpty()) return;

        // Tokenize: pisahkan angka dan operator
        String[] tokens = ekspresi.split(" ");
        // tokens = ["10", "+", "20", "*", "30"]

        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<String> ops = new ArrayList<>();

        for (String token : tokens) {
            token = token.trim();
            if (token.isEmpty()) continue;

            if (token.equals("+") || token.equals("-") ||
                    token.equals("*") || token.equals("/")) {
                ops.add(token);
            } else {
                nums.add(Integer.parseInt(token));
            }
        }

        int i = 0;
        while (i < ops.size()) {
            String op = ops.get(i);
            if (op.equals("*") || op.equals("/")) {
                int left  = nums.get(i);
                int right = nums.get(i + 1);
                int result;

                if (op.equals("*")) {
                    result = left * right;
                } else {
                    if (right == 0) {
                        jawaban.setText("Error: Bagi 0");
                        return;
                    }
                    result = left / right;
                }

                nums.set(i, result);
                nums.remove(i + 1);
                ops.remove(i);

            } else {
                i++;
            }
        }

        int finalResult = nums.get(0);
        for (int j = 0; j < ops.size(); j++) {
            String op = ops.get(j);
            int next = nums.get(j + 1);

            if (op.equals("+")) {
                finalResult += next;
            } else if (op.equals("-")) {
                finalResult -= next;
            }
        }

        jawaban.setText(String.valueOf(finalResult));
        angkas = new StringBuilder();
        inputan.setText("");
    }

}
