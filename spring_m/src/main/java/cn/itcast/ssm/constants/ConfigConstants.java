package cn.itcast.ssm.constants;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ConfigConstants {
	private static ConfigConstants instance;
	private Map<String, String> webMap;

	private ConfigConstants() {
		if (this.webMap == null) {
			this.webMap = new HashMap<String, String>();
		}
		parserXml();
	}

	public static ConfigConstants getInstance() {
		synchronized (ConfigConstants.class) {
			if (instance == null) {
				instance = new ConfigConstants();
			}
			return instance;
		}
	}

	public static void main(String[] args) {
		ConfigConstants.getInstance();
	}

	private void parserXml() {
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(getClass().getResourceAsStream("/assets/cfg.xml"));
			Element rootEl = doc.getRootElement();

			List<Element> webs = rootEl.getChildren("webConfig");
			String webname;
			for (Element w : webs) {
				webname = w.getAttributeValue("name");
				String value = w.getChildText("value");
				this.webMap.put(webname, value);
			}
			// 版本
			List<Element> appVersions = rootEl.getChildren("appVersion");
			for (Element e : appVersions) {
				String name = e.getAttributeValue("name");
				String value = e.getChildText("value");
				this.webMap.put(name, value);
			}

		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getPath(String name) {
		return (String) this.webMap.get(name);
	}

	public String getWebPath() {
		return getPath("webPath");
	}

	public String getWebDomain() {
		return getPath("webDomain");
	}

	public String getWechatAppId() {
		return getPath("wechatConfigAppId");
	}

	public String getWechatMchId() {
		return getPath("wechatConfigMchId");
	}

	public String getWechatMchKey() {
		return getPath("wechatConfigMchKey");
	}

	public String wechatPayAppCallbackRecharge() {
		return getPath("wechatConfigPayAppCallbackRecharge");
	}

	public String getAlipayGateWay() {
		return getPath("alipayGateWay");
	}

	public String getAlipayAccount() {
		return getPath("alipay_account");
	}

	public String getAlipayAppId() {
		return getPath("alipay_appId");
	}

	public String getAlipayPublicKey() {
		return getPath("alipay_publicKey");
	}

	public String getAlipayAppPublicKey() {
		return getPath("alipay_appPublicKey");
	}

	public String getAlipayAppPrivateKey() {
		return getPath("alipay_appPrivateKey");
	}

	public String getAlipayContentAesKey() {
		return getPath("alipay_contentAESKey");
	}

	public String getAlipaySignType() {
		return getPath("alipay_signType");
	}

	public String getAlipayCharset() {
		return getPath("alipay_charset");
	}

	public String getAlipayAppCallbackRecharge() {
		return getPath("alipayAppCallbackRecharge");
	}

	public String getAliAccessKeyId() {
		return getPath("accessKeyId");
	}

	public String getAliAccessKeySecret() {
		return getPath("accessKeySecret");
	}

	public String getAliSignName() {
		return getPath("signName");
	}

	public String getJpushAppKey() {
		return getPath("appKey");
	}

	public String getJpushSecret() {
		return getPath("masterSecret");
	}

	public String getJpushAppKey4Sec() {
		return getPath("appKey4Sec");
	}

	public String getJpushSecret4Sec() {
		return getPath("masterSecret4Sec");
	}

}
