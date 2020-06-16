package com.example.recyclerview
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val imageList = listOf<ItemOfList>(
            ItemOfList(
                R.drawable.image1,
                "Путин рассказал о двух задачах властей во время пандемии",
                "Перед российскими властями во время эпидемии COVID-19 стояли две задачи — обеспечить безопасность граждан и сработать на опережение,"+
                        " заявил Владимир Путин на совещании по вопросам реализации принятых мер по поддержке экономики и социальной сферы."
            ),
            ItemOfList(
                R.drawable.image2,
                "Пола Уилана приговорили к 16 годам колонии",
                "Мосгорсуд приговорил американца Пола Уилана к 16 годам колонии строгого режима режима за шпионаж,"+
                        " передает корреспондент РИА Новости из зала суда."+
                        "Обвинение запрашивало для него 18 лет колонии. Сам Уилан в последнем слове заявил, что шпионажем не занимался."+
                        "Он намерен обжаловать приговор."+
                        "Адвокат предполагает, что Уилана могут обменять на Виктора Бута или Константина Ярошенко,"+
                        " которые содержатся в американских тюрьмах."+
                        "За процессом пристально следили в США, на заседания неоднократно приезжал американский посол,"+
                        " но непосредственно в зал суда его не пустили ни разу."+
                        " Так как в деле гриф совершенно секретно, рассмотрение проходило в закрытом режиме."+
                        "За время содержания под стражей Уилан регулярно жаловался на состояние здоровья, качество медпомощи,"+
                        " запрет звонить родителям, угрозы со стороны сотрудников СИЗО и прочее."
            ),
            ItemOfList(
                R.drawable.image3,
                "Было бы классно получить за эту практическую работу пять!",
                "Неправда ли?"
            ),
            ItemOfList(
                R.drawable.image4,
                "Станет ли наруто хокаге? Читайте далее...",
                "Спойлер, станет!"
            )
        )
        val recyclerView = findViewById<RecyclerView>(R.id._imageRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ItemAdapter(this, imageList){
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("OBJECT_INTENT", it)
            startActivity(intent)
        }
    }
}