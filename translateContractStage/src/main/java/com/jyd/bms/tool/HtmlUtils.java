package com.jyd.bms.tool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HtmlUtils {
	private static final Logger log = LoggerFactory.getLogger(HtmlUtils.class);
	
	public static HttpURLConnection httpConn = null;

	/**
	 * @category 创建静态页面
	 * @param filePath
	 *            存静态页面的路径
	 * @param webUrl
	 *            请求服务器的路径
	 * @param chart
	 *            编码
	 * @return
	 */
	public static boolean createHtmlPage(final String filePath, final String webUrl, final String chart) {
		String rLine = null;
		PrintWriter fileOut = null;
		InputStream ins = null;
		try {
			URL url = new URL(webUrl);
			// 连接建立超时时间还有读取数据超时时间，
			httpConn = (HttpURLConnection) url.openConnection();
			httpConn.setConnectTimeout(600000);
			httpConn.setReadTimeout(600000);
			httpConn.setRequestMethod("GET");
			httpConn.connect();
			ins = httpConn.getInputStream();
			// 获取状态码
			int code = httpConn.getResponseCode();
			if (code != 200) {
				return false;
			}
			final BufferedReader bReader = new BufferedReader(new InputStreamReader(ins, chart));
			final File file = new File(filePath);
			// 判断目标文件所在的目录是否存在
			if (!file.getParentFile().exists()) {
				// 如果目标文件所在的目录不存在，则创建父目录
				if (!file.getParentFile().mkdirs()) {
					System.out.println("创建目标文件所在目录失败！");
					return false;
				}
			}
			if (file.exists()) {
				file.deleteOnExit();
			}
			final FileOutputStream out = new FileOutputStream(file);
			final OutputStreamWriter writer = new OutputStreamWriter(out, chart);
			fileOut = new PrintWriter(writer);
			while ((rLine = bReader.readLine()) != null) {
				String tmp_rLine = rLine;
				final int str_len = tmp_rLine.length();
				if (str_len > 0) {
					fileOut.println(tmp_rLine);
					fileOut.flush();
				}
				tmp_rLine = null;
			}
			url = null;
			return true;
		} catch (IOException e) {
			System.out.println("error: " + e.getMessage());
			return false;
		} catch (Exception es) {
			System.out.println("error: " + es.getMessage());
			return false;
		} finally {
			if (ins != null) {
				try {
					ins.close();
				} catch (IOException e) {
					return false;
				}
			}
			if (fileOut != null) {
				fileOut.close();
			}
		}
	}
}
