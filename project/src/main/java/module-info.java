module ExpenseForm {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires transitive javafx.graphics;
    requires com.github.f4b6a3.uuid;
    
    opens ExpenseForm to javafx.fxml;
    exports ExpenseForm;
    exports ExpenseForm.model;
}
