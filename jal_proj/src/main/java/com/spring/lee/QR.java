package com.spring.lee;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QR {

	public void create(String str, String fileName, String formatType) {
		int textColor = 0xFF2e4e96;
		int backgroundColor = 0xFFFFFFFF;
		int width = 200;
		int height = 200;
		
		create(str, fileName, formatType, width, height, textColor, backgroundColor);
	}
	public void create(String str, String fileName, String formatType, int width, int height) {
		int textColor = 0xFF2e4e96;
		int backgroundColor = 0xFFFFFFFF;

		create(str, fileName, formatType, width, height, textColor, backgroundColor);
	}
	/**
	 * 
	 * @param str
	 * 		QR로 변환할 문자열
	 * @param fileName
	 * 		저장할 QR 파일명 - 확장자 없이 파일명만
	 * @param formatType
	 * 		저장할 QR 이미지 타입 - png 등
	 * @param width
	 * 		QR 이미지 너비
	 * @param height
	 * 		QR 이미지 높이
	 * @param tformatTypeColor
	 * 		QR 색상
	 * @param backgroundColor
	 * 		QR 배경 색상
	 */
	public void create(String str, String fileName, String formatType, int width, int height, int textColor, int backgroundColor) {
		

		try {
			// QR 저장할 폴더 지정
			File dir = new File("C:\\file_repo");
			
			// 없으면 만들어주기
			if (!dir.exists()) {
				dir.mkdirs();
			}
			
			

			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			
			BitMatrix bitMatrix = qrCodeWriter.encode(str, BarcodeFormat.QR_CODE, width, height);
			MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(textColor, backgroundColor);
			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);

			// ImageIO를 사용한 바코드 파일쓰기
			ImageIO.write(bufferedImage, formatType, new File(dir, fileName+"."+formatType));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
