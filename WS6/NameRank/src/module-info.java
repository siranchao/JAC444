module NameRank {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	opens nameRank to javafx.graphics, javafx.fxml;
}
