package trabalhodia16;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class dashboardController implements Initializable {

    @FXML
    private AnchorPane main_form;

    @FXML
    private Button avaliableLanches_Btn;

    @FXML
    private Button avaliableLanches_addBtn;

    @FXML
    private Button avaliableLanches_cleanBtn;

    @FXML
    private TableColumn<?, ?> avaliableLanches_col_Price;

    @FXML
    private TableColumn<?, ?> avaliableLanches_col_lanchesNome;

    @FXML
    private TableColumn<?, ?> avaliableLanches_col_lanchesid;

    @FXML
    private TableColumn<?, ?> avaliableLanches_col_status;

    @FXML
    private Button avaliableLanches_deleteBtn;

    @FXML
    private AnchorPane avaliableLanches_form;

    @FXML
    private ImageView avaliableLanches_imageView;

    @FXML
    private Button avaliableLanches_importBtn;

    @FXML
    private TextField avaliableLanches_lanchesID;

    @FXML
    private TextField avaliableLanches_lanchesNome;

    @FXML
    private TextField avaliableLanches_price;

    @FXML
    private TextField avaliableLanches_search;

    @FXML
    private ComboBox<?> avaliableLanches_status;

    @FXML
    private TableView<?> avaliableLanches_tabeleView;

    @FXML
    private Button avaliableLanches_updateBtn;

    @FXML
    private Button close;

    @FXML
    private Button home_Btn;

    @FXML
    private Label home_avaliableLanches;

    @FXML
    private BarChart<?, ?> home_chart;

    @FXML
    private AnchorPane home_form;

    @FXML
    private Label home_totalcostumes;

    @FXML
    private Label home_totalincome;

    @FXML
    private Button logoutbtn;

    @FXML
    private Button minimize;

    @FXML
    private ComboBox<?> purchase_LanchesID;

    @FXML
    private ComboBox<?> purchase_LanchesName;

    @FXML
    private TableColumn<?, ?> purchase_col_lanchesID;

    @FXML
    private TableColumn<?, ?> purchase_col_lanchesNames;

    @FXML
    private TableColumn<?, ?> purchase_col_price;

    @FXML
    private TableColumn<?, ?> purchase_col_quantity;

    @FXML
    private AnchorPane purchase_form;

    @FXML
    private Button purchase_payBtn;

    @FXML
    private Spinner<?> purchase_quantity;

    @FXML
    private TableView<?> purchase_tableView;

    @FXML
    private Label purchase_total;

    @FXML
    private Button purchcase_btn;

    public void close() {
        System.exit(0);

    }

    public void minimize() {

        Stage stage = (Stage) main_form.getScene().getWindow();
        stage.setIconified(true);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}