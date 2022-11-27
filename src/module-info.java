module Sycopa {
	
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.xml;
	requires java.desktop;
	requires javafx.base;
	requires org.junit.jupiter.api;
	
	opens application.controller to javafx.graphics, javafx.fxml;
	exports application;
}