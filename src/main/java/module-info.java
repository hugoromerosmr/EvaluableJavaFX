module org.example.evaluablejavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;


    opens org.example.evaluablejavafx to javafx.fxml;
    exports org.example.evaluablejavafx;
}