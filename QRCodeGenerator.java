/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package qrcodegenerator;

/**
 *
 * @author SANJANA NR
 */
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CustomErrorCorrectionQRCodeGenerator {
    public static void main(String[] args) {
        String data = "https://www.example.com";
        String filePath = "CustomQRCode.png";
        int width = 300;
        int height = 300;

        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

            BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, hints);
            MatrixToImageWriter.writeToPath(bitMatrix, "PNG", new File(filePath).toPath());
            System.out.println("Custom QR Code generated successfully: " + filePath);
        } catch (WriterException | IOException e) {
            System.err.println("Error generating Custom QR Code: " + e.getMessage());
        }
    }
}