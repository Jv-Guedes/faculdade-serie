package Controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.SerieDAO;
import Model.Serie;

public class ExibirController {


	
	private JTable table;
	public String column[]={"Serie","Episodio", "Ano","Temporada", "Ja Viu?", "Nota"};         

	public ExibirController(JTable table) throws ClassNotFoundException {
		this.table = table;
		this.getLivros();
	}
	
	public String getLivros() throws ClassNotFoundException {
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		try {
			SerieDAO serieDao = new SerieDAO();
			List<Serie> list = serieDao.getAllSerie();
                        System.out.println(list);
                        if(!list.isEmpty()){
                            for (Serie serie : list) {
                                    model.addRow(new Object[] {
                                                    serie.getSerie(),
                                                    serie.getEpisodio(),
                                                    serie.getAno(),
                                                    serie.getTemporada(),
                                                    serie.getJaAssitiu(),
                                                    serie.getNota()
                                    });
                            }
                        }
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
        

	
}