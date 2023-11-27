package gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

public class AgendarConsultaController {

	@FXML
	private ComboBox<String> comboBoxMedicosDisponiveis;

	@FXML
	private DatePicker datePickerDatas;

	@FXML
	private Button botaoAgendarConsulta;

	@FXML
	public void initialize() {
		String url = "jdbc:mysql://localhost:3306/hospital?useSSL=false";
		String username = "developer";
		String password = "86779791";

		if (TelaLoginPacienteController.getPlanoLogado() != null) {
			String selectQuery = "SELECT * FROM medicoscadastrados WHERE plano_atendido = ? ";
			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

				preparedStatement.setString(1, TelaLoginPacienteController.getPlanoLogado());

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						String nome = resultSet.getString("nome");
						String especialidade = resultSet.getString("especialidade");
						String nomeEspecialidade = nome + " - " + especialidade;
						comboBoxMedicosDisponiveis.getItems().addAll(nomeEspecialidade);
					}
				} catch (SQLException e) {
					e.getMessage();
				}

			} catch (SQLException e) {
				e.getMessage();
			}
		} else {
			String selectQuery = "SELECT * FROM medicoscadastrados";
			try (Connection connection = DriverManager.getConnection(url, username, password);
					PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {

				try (ResultSet resultSet = preparedStatement.executeQuery()) {
					while (resultSet.next()) {
						String nome = resultSet.getString("nome");
						String especialidade = resultSet.getString("especialidade");
						String nomeEspecialidade = nome + " - " + especialidade;
						comboBoxMedicosDisponiveis.getItems().addAll(nomeEspecialidade);
					}
				} catch (SQLException e) {
					e.getMessage();
				}
			} catch (SQLException erro) {
				erro.printStackTrace();
			}
		}
		
		datePickerDatas.setDayCellFactory(new Callback<DatePicker, DateCell>() {
            @Override
            public DateCell call(DatePicker param) {
                return new DateCell() {
                    @Override
                    public void updateItem(LocalDate item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item.isBefore(LocalDate.now())) {
                            setDisable(true);
                            setStyle("-fx-background-color: #D3D3D3;"); // Change the color to indicate disabled dates
                        }
                    }
                };
            }
        });
	}
	
	public void cliqueBotaoAgendamento() {
		String medicoEscolhido = comboBoxMedicosDisponiveis.getValue();
		LocalDate dataEscolhida = datePickerDatas.getValue();
		
		
	}
}