
package Controller;

import Model.Serie;
import View.CadastrarView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class CadastrarController implements ActionListener {

    
    private JTextField textTitulo;
    private JComboBox comboTemp;
    private JComboBox checkAno;
    private JTextField textNota;
    private JComboBox comboSerie;    
    private JCheckBox checkAssistido;
    private JButton btnCadastrar;
    private List<Serie> listaLivros;
    
    
    public CadastrarController(
            JTextField textTitulo,
            JComboBox comboSerie,
            JComboBox comboTemp,
            JComboBox checkAno,
            JCheckBox checkAssistido,
            JTextField textNota,
            JButton btnCadastrar
    ){
        this.textTitulo = textTitulo;
        this.comboSerie = comboSerie;
        this.comboTemp = comboTemp;
        this.checkAno = checkAno;
        this.checkAssistido = checkAssistido;
        this.textNota = textNota;
        this.popularComboAno();
        this.popularComboTemporada();
        this.popularComboSerie();
        listaLivros = new ArrayList<>();
    }
    
    
    private void popularComboAno() {
        
        this.checkAno.removeAll();
        int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
        
        for (int anoLoop = anoAtual ; anoLoop >= 1980 ; anoLoop --) {
            this.checkAno.addItem(anoLoop);
        }
    }
    
    private void popularComboSerie() {
        String[] serie = new String[] { "Escolha sua série",
            "Friends",
            "Breaking Bad",
            "Arquivo X",
            "Game of Thrones",
            "Seinfeld",
            "Família Soprano",
            "Os Simpsons",
            "Anos Incríveis",
            "Family Guy",
            "24 Horas"
        };
        for (String serieLoop : serie) {
            this.comboSerie.addItem(serieLoop);
        }
    }
    
    private void popularComboTemporada() {
        for (int i = 1; i < 11; i++) {
            this.comboTemp.addItem("Temporada " + i);
        }
    }
    
    private void criarNovoEpisodio(){
        Serie livro = new Serie(
            this.comboSerie.getSelectedItem().toString(),
            this.textTitulo.getText(),
            this.comboTemp.getSelectedItem().toString(),
            Integer.parseInt(this.checkAno .getSelectedItem().toString()),
            this.checkAssistido.isSelected(),
            this.textNota.getText()
        );
        
        
        listaLivros.add(livro);
        
        for (Serie livroLoop : listaLivros) {
            System.out.println(livroLoop.toString());
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        
        System.out.println(arg0.getActionCommand());
        this.criarNovoEpisodio();
    }
    
}
