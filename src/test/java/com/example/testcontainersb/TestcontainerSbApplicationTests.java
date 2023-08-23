package com.example.testcontainersb;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.codeborne.selenide.WebDriverRunner;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

import java.nio.file.Paths;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
class TestcontainerSbApplicationTests {

	@Container
	private static BrowserWebDriverContainer container = new BrowserWebDriverContainer<>()
			.withRecordingMode(
					RECORD_ALL,
					Paths.get(".", "target").toFile())
			.withCapabilities(new FirefoxOptions());

	@Test
	void test() {
		RemoteWebDriver remote = new RemoteWebDriver(
				container.getSeleniumAddress(),
				new FirefoxOptions());

		WebDriverRunner.setWebDriver(remote);

		open("https://google.com?q=selenide");

		$$("form")
				.filterBy(exist)
				.first()
				.shouldBe(visible)
				.submit();

		$(byValue("selenide"))
				.shouldBe(exist)
				.shouldBe(visible)
				.submit();

	}

}
