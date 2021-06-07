package br.com.local.applista2h_12021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ListView listarFilmes;

    //Criando os arrays de filmes
    String nomesFilmes[] = {"Raya e o Último Dragão (2021)", "Godzilla vs. Kong (2021)",
            "Sem Remorso (2021)", "Eu Sou Todas as Meninas (2021)",
            "Ferry (2021)", "Espiral (2021)"};
    int imagensFilmes[] = {R.drawable.raya, R.drawable.godzilla, R.drawable.sretorno,
            R.drawable.todasmeninas, R.drawable.ferry, R.drawable.espiral};
    String classFilmes[] = {"70%", "80%", "90%", "82%", "75%", "82%"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listarFilmes = findViewById(R.id.idListView);

        //Instanciar minha classe de adapter
        FilmesAdapter filmesAdapter = new FilmesAdapter();

        //Inserindo os itens na lista
        listarFilmes.setAdapter(filmesAdapter);
    }
    //inner class

    public class FilmesAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return imagensFilmes.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        //inflar o meu modelo e todos os componentes do modelo
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //Declarando os componentes que serão modificados na lista
            ImageView imgFilme;
            TextView titFilme, avalFime;

            //Inflando o modelo do layout para ser inserido na listView
            View view = getLayoutInflater().inflate(R.layout.modelo_lista, null);

            //Apresentando os componentes xml ao java
            imgFilme = view.findViewById(R.id.imgFilmes);
            titFilme = view.findViewById(R.id.txtTituloFilme);
            avalFime = view.findViewById(R.id.txtAvalFilme);

            //inserindo os valores dos componentes nas variaveis java;
            titFilme.setText(nomesFilmes[position]);
            avalFime.setText(classFilmes[position]);
            imgFilme.setImageResource(imagensFilmes[position]);

            return view;
        }
    }


}