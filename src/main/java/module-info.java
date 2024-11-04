module org.example.evaluablejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.evaluablejavafx to javafx.fxml;
    exports org.example.evaluablejavafx;
}