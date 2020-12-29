package com.todolist.tutodooapp

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val wb = findViewById<WebView>(R.id.webView)
        wb.settings.javaScriptEnabled = true
        wb.settings.loadWithOverviewMode = true
        wb.settings.useWideViewPort=true

        wb.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return false
            }

            override fun onPageFinished(view: WebView, url: String) {

                view.loadUrl(
                    "javascript:(function() {" +
                            "var arr = [" +
                            "'12/30/2020'," +
                            "'A351295'," +
                            "'8880661716'," +
                            "'In Bangalore'," +
                            "['None']," +
                            "'No'," +
                            "'No'," +
                            "'No'," +
                            "'No'," +
                            "'No'," +
                            "'No'," +
                            "'Green'," +
                            "'In Office - Tridib'" +
                            "];" +
                            "var i = 0;" +
                            "$('.office-form-question-content').each(function() {" +
                            "var input = $(this).find('input');" +
                            "if(!(input && input.length)) {" +
                            "return;" +
                            "}" +
                            "var val = arr[i];" +
                            "var type = input.attr('type');" +
                            "if(type=='radio') {" +
                            "input.filter(function() {" +
                            "return $(this).attr('value') == val;" +
                            "}).prop('checked',true);" +
                            "} else if(type=='checkbox') {" +
                            "val = Array.isArray(val) ? val : [val];" +
                            "input.filter(function() {" +
                            "return val.indexOf($(this).attr('value'))!=-1;" +
                            "}).prop('checked',true);" +
                            "} else {" +
                            "input.val(val);" +
                            "}" +
                            "i++;" +
                            "});" +
                            "$('.office-form-navigation-container button').trigger('click')"+
                            "})()"
                )
            }
        }
        wb.loadUrl("https://forms.office.com/Pages/ResponsePage.aspx?id=rpNU8pgc10GKMwvnX1_mAwucrtzwrmNKi8Ys4vsF3hNUOVQxNTc3MzhCOUpUSFlKM1kyM0ZVTDdEWi4u")


    }
}