module NewFx {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;
	
	opens myApp to javafx.graphics, javafx.fxml;
}
