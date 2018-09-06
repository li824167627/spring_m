package cn.itcast.ssm.controller.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ApiController {

	@RequestMapping("/getData")
	public void readApi(HttpServletResponse response) {
		Logger.getLogger(ApiController.class).info("api:" + getClass().getResource("/"));
		String path = getClass().getResource("/com/fm/portal/controller/api/api.json").getFile();
		File file = new File(path);
		if (file.exists()) {
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(file);
				byte[] buf = new byte[1024];
				int len = -1;
				while ((len = fis.read(buf)) != -1) {
					response.getOutputStream().write(buf, 0, len);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
