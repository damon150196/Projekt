package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import application.blocks.BorderedTitledPane;
import application.blocks.*;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class Main extends Application
{
	BorderPane root = new BorderPane();
	Scene scene = new Scene(root,1000,650);
	BorderPane top = new BorderPane();
	BorderedTitledPane left = new BorderedTitledPane("Sk³adnia jêzyka");
	BorderedTitledPane right = new BorderedTitledPane("Podgl¹d Kodu");
	boolean rightShowed = true;
	BorderedTitledPane content = new BorderedTitledPane("Obszar Roboczy");
	File file = null;


	//top
	HBox top_r = new HBox(2);
	HBox top_l = new HBox(2);
	Button top_new = new Button("\uD83D\uDCC4");
	Button top_open = new Button("\uD83D\uDCC2");
	Button top_save = new Button("\uD83D\uDCBE");
	Button refresh = new Button("\u21BB");
	Button podglad = new Button("Podglad Kodu");
	Button consolButton = new Button("Uruchom \u25B6");

	//left
	ScrollPane leftSP = new ScrollPane();
	VBox leftVB = new VBox();

	//Center
	VBox content2 = new VBox();
	MainBlock mainBlock = new MainBlock(leftVB);
	StackPane content22 = new StackPane();

	//Right
	TextArea sourceCode = new TextArea();






	public static void main(String[] args)
	{
		launch(args);
	}


	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			primaryStage.setTitle("Projekt Kompetencyjny");
			root.getStyleClass().add("color-gray");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			//============================ TOP PANEL =====================================


			this.init_fileButtons();
			this.init_functionalButtons();

			top_l.getChildren().add(top_new);
			top_l.getChildren().add(top_open);
			top_l.getChildren().add(top_save);
			top_r.getChildren().add(refresh);
			top_r.getChildren().add(podglad);

			top.setLeft(top_l);
			top.setRight(top_r);
			top.setCenter(consolButton);
			root.setTop(top);




			//============================ LEFT PANEL =====================================
			left.setPrefSize(200, 600);

			leftSP.setContent(leftVB);
			left.getChildren().add(leftSP);

			root.setLeft(left);

			//============================ CONTENT PANEL =====================================
			content.setPrefHeight(600);
			content2.getChildren().add(mainBlock);
			content2.getChildren().add(content22);

			content.getChildren().add(content2);

			root.setCenter(content);

			//============================ RIGHT PANEL =====================================
			right.setPrefSize(300, 600);

			sourceCode.setEditable(false);
			sourceCode.getStyleClass().add("console");

			right.getChildren().add(sourceCode);

			root.setRight(right);



			//=============================================================================
			primaryStage.setScene(scene);
			primaryStage.show();


			primaryStage.setOnCloseRequest(closeEvent);

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}





	public void init_fileButtons()
	{
		// -------------------------------- NEW --------------------------------------------------
		top_new.getStyleClass().add("btn");
		top_new.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				if(! mainBlock.isEmpty())
				{
					Alert alert = new Alert(AlertType.CONFIRMATION, "Czy zapisac projekt", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);

					alert.setTitle("Zapisywanie");
					alert.showAndWait().ifPresent(type -> {
						if (type == ButtonType.YES)
						{
							save();
							mainBlock.clear();
						}
						else if (type == ButtonType.NO)
						{
							mainBlock.clear();
						}
					});
				}
			}
		});


		// -------------------------------- Open --------------------------------------------------

		top_open.getStyleClass().add("btn");
		top_open.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				if(! mainBlock.isEmpty())
				{
					Alert alert = new Alert(AlertType.CONFIRMATION, "Czy zapisa? projekt", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);

					alert.setTitle("Zapisywanie");
					alert.showAndWait().ifPresent(type -> {
						if (type == ButtonType.YES)
						{
							save();
							open();
						}
						else if (type == ButtonType.NO)
						{
							open();
						}

					});
				}
				open();

			}
		});



		// -------------------------------- NEW --------------------------------------------------
		top_save.getStyleClass().add("btn");
		top_save.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				if(mainBlock.isEmpty())
				{
					Alert alert = new Alert(AlertType.CONFIRMATION, "Projekt jset pusty, zapis nie udany", ButtonType.OK);
					alert.setTitle("Zapisywanie");
				}
				else
				{
					save();
				}
			}
		});
	}





	public void init_functionalButtons()
	{

		refresh.getStyleClass().add("btn");
		refresh.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				sourceCode.setText(mainBlock.getFunctionString(0));
			}
		});

		podglad.getStyleClass().add("btn2");
		podglad.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				if(rightShowed==false)
				{
					root.setRight(right);
					rightShowed=true;
				}
				else
				{
					root.setRight(null);
					rightShowed=false;
				}
			}
		});


		consolButton.getStyleClass().add("btn2");
		consolButton.setOnAction((EventHandler<ActionEvent>) new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event)
			{
				if(! mainBlock.isEmpty())
				{
					sourceCode.setText(mainBlock.getFunctionString(0));
					save();
				}

				Console console = new Console(file);
				Stage consoleStage = new Stage();
				console.start(consoleStage);
			}
		});
	}


	//naprawiæ metode zamykania aplikacji (problem z dodaniem opcji wyboru zapisu przed zamknieciem okna aplikacj)
	EventHandler<WindowEvent> closeEvent = new EventHandler<WindowEvent>()
	{
		@Override
		public void handle(WindowEvent event)
		{
			/*if(file!=null)
			{
				try
				{
					ReadFile rf = new ReadFile(file);


					if(! mainBlock.isEmpty() && ! rf.read().equals(mainBlock.getFunctionString(0)))
					{
						Alert alert = new Alert(AlertType.CONFIRMATION, "Czy zapisa? projekt", ButtonType.YES, ButtonType.NO);
						alert.setTitle("Zapisywanie");
						alert.showAndWait().ifPresent(type -> {
							if (type == ButtonType.YES)
							{
								save();
							}
						});
					}
				}
				catch (FileNotFoundException e)
				{
					Alert alert2 = new Alert(AlertType.ERROR, "Problem z plikiem", ButtonType.OK);
					alert2.setTitle("Error");
					alert2.show();
				}
				catch (IOException e)
				{
					//Alert alert2 = new Alert(AlertType.ERROR, "Problem z plikiem", ButtonType.OK);
					//alert2.setTitle("Error");
					//alert2.show();
				}

			}
			else if(! mainBlock.isEmpty())
			{
				Alert alert = new Alert(AlertType.CONFIRMATION, "Czy zapisa? projekt", ButtonType.YES, ButtonType.NO);
				alert.setTitle("Zapisywanie");
				alert.showAndWait().ifPresent(type -> {
					if (type == ButtonType.YES)
					{
						save();
					}
				});

			}*/

		}
	};


	public void save()
	{
		try
		{
			SaveFile sf = new SaveFile(file);
			if(sf.getFile() == null) throw new NullPointerException();
			file = sf.getFile();
			sf.write(mainBlock.getFunctionString(0));
		}
		catch (IOException e)
		{
			Alert alert2 = new Alert(AlertType.ERROR, "Zapis nie powiód? si?", ButtonType.OK);
			alert2.setTitle("Error");
			alert2.showAndWait();
		}
		catch (NullPointerException e)
		{
			//Alert alert2 = new Alert(AlertType.ERROR, "Zapis nie powiód? si?", ButtonType.OK);
			//alert2.setTitle("Error");
			//alert2.showAndWait();
		}
	}

	public void open()
	{
		try
		{
			ReadFile rf = new ReadFile(file);
			if(rf.getFile() == null) throw new NullPointerException();
			file = rf.getFile();
			sourceCode.setText(rf.read());
		}
		catch (IOException e)
		{
			Alert alert2 = new Alert(AlertType.ERROR, "Odczyt nie powiód? si?", ButtonType.OK);
			alert2.setTitle("Error");
			alert2.showAndWait();
		}
		catch (NullPointerException e)
		{
			Alert alert2 = new Alert(AlertType.ERROR, "Odczyt nie powiód? si?", ButtonType.OK);
			alert2.setTitle("Error");
			alert2.showAndWait();
		}

	}

}