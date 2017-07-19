package com.shop.utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

//图像数据转换工具类
public class ImageUtil
{

	// 将字节数组转换存储到一个文件里
	public static void bytesToFile(byte[] data, String fileName)
	{
		try
		{
			FileOutputStream fos = new FileOutputStream(fileName);
			fos.write(data);
			fos.close();
		} catch (Exception e)
		{
			throw new RuntimeException("将字节数组存到文件时错误：" + e);
		}

	}

	// 将一个字符串（格式为"33,22,45,..."）转换成一个字节数组
	public static byte[] stringToBytes(String str)
	{
		try
		{
			String[] strs = str.split(",");
			byte[] data = new byte[strs.length];
			for (int i = 0; i < strs.length; i++)
			{
				data[i] = Byte.parseByte(strs[i]);
			}
			return data;
		} catch (Exception e)
		{
			throw new RuntimeException("转换字符串到字节数组时出错！" + e);
		}
	}

	// 将一个Png图片文件转换成一个字节数组
	public static byte[] pngToBytes(String pngFileName)
	{
		try
		{
			BufferedImage image = ImageIO.read(new File(pngFileName));
			return imageToBytes(image);
		} catch (Exception e)
		{
			throw new RuntimeException("转换Png文件到字节数组时出错！" + e);
		}

	}

	// 将一个图像对象转换成字节数组
	public static byte[] imageToBytes(BufferedImage image)
	{
		try
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(image, "png", baos);
			byte[] result = baos.toByteArray();
			baos.close();
			return result;
		} catch (Exception e)
		{
			throw new RuntimeException("转换图像对象到字节数组时出错！" + e);
		}

	}

	// 将一个Png图片文件按缩放比例转换成一个字节数组
	public static byte[] pngToBytes(String pngFileName, double scale)
	{
		try
		{
			BufferedImage image = ImageIO.read(new File(pngFileName));
			// 获取一个宽、长是原来scale的图像实例
			int width = image.getWidth();
			int height = image.getHeight();
			Image zoomedImage = image.getScaledInstance((int) (width * scale), (int) (height * scale), Image.SCALE_DEFAULT);
			// 缩放图像
			BufferedImage tag = new BufferedImage((int) (width * scale), (int) (height * scale), BufferedImage.TYPE_INT_RGB);
			Graphics2D g = tag.createGraphics();
			g.drawImage(zoomedImage, 0, 0, null); // 绘制缩小后的图
			g.dispose();
			return imageToBytes(tag);
		} catch (Exception e)
		{
			throw new RuntimeException("转换Png文件到字节数组时出错！" + e);
		}

	}

	// 将一个字节数组保存成一个Png图片文件
	public static void bytesToPng(byte[] data, String pngFileName)
	{
		try
		{
			BufferedImage image = bytesToImage(data);
			ImageIO.write(image, "png", new File(pngFileName));
		} catch (Exception e)
		{
			throw new RuntimeException("转换字节数组到Png文件时出错！" + e);
		}

	}

	// 将一个字节数组保存成一个图像对象
	public static BufferedImage bytesToImage(byte[] data) throws IOException
	{
		try
		{
			ByteArrayInputStream bais = new ByteArrayInputStream(data);
			BufferedImage image = ImageIO.read(bais);
			bais.close();
			return image;
		} catch (Exception e)
		{
			throw new RuntimeException("转换字节数组到图像对象时出错！" + e);
		}
	}

	// 将给定的图像按给定比例缩放
	public static Image zoomImage(BufferedImage image, double zoomRation)
	{
		int width = (int) (image.getWidth() * zoomRation);
		int height = (int) (image.getHeight() * zoomRation);
		Image zoomedImage = image.getScaledInstance(width, height, Image.SCALE_FAST);
		return zoomedImage;
	}

}
