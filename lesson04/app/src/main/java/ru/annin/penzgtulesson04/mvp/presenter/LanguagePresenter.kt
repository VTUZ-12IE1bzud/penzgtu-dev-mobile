package ru.annin.penzgtulesson04.mvp.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.annin.penzgtulesson04.R
import ru.annin.penzgtulesson04.mvp.model.Language
import ru.annin.penzgtulesson04.mvp.view.LanguageView

/**
 * Presenter экрана "Языков программирования".
 *
 * @author Pavel Annin.
 */
@InjectViewState
class LanguagePresenter : MvpPresenter<LanguageView>() {

    companion object {
        private val languages: List<Language> = listOf(
                Language("Java", R.drawable.ic_java, "Java — сильно типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle). Приложения Java обычно транслируются в специальный байт-код, поэтому они могут работать на любой компьютерной архитектуре, с помощью виртуальной Java-машины. Дата официального выпуска — 23 мая 1995 года."),
                Language("Kotlin", R.drawable.ic_kotlin, "Kotlin — статически типизированный язык программирования, работающий поверх JVM и разрабатываемый компанией JetBrains. Компилируется также в JavaScript и на другие платформы через инфраструктуру LLVM. Язык назван в честь острова Котлин в Финском заливе, на котором расположен город Кронштадт. Авторы ставили целью создать язык более лаконичный и типобезопасный, чем Java, и более простой, чем Scala. Следствием упрощения по сравнению со Scala стали также более быстрая компиляция и лучшая поддержка языка в IDE."),
                Language("Golang", R.drawable.ic_golang, "Go (часто также Golang) — компилируемый многопоточный язык программирования, разработанный компанией Google. Первоначальная разработка Go началась в сентябре 2007 года, а его непосредственным проектированием занимались Роберт Гризмер, Роб Пайк и Кен Томпсон, занимавшиеся до этого проектом разработки операционной системы Inferno. Официально язык был представлен в ноябре 2009 года. На данный момент его поддержка осуществляется для операционных систем FreeBSD, OpenBSD, Linux, Mac OS X, Windows, начиная с версии 1.3 в язык Go включена экспериментальная поддержка DragonFly BSD, Plan 9 и Solaris, начиная с версии 1.4 — поддержка платформы Android."),
                Language("Swift", R.drawable.ic_swift, "Swift — открытый мультипарадигмальный компилируемый язык программирования общего назначения. Создан компанией Apple в первую очередь для разработчиков iOS и macOS. Swift работает с фреймворками Cocoa и Cocoa Touch и совместим с основной кодовой базой Apple, написанной на Objective-C. Swift задумывался как более легкий для чтения и устойчивый к ошибкам программиста язык, нежели предшествовавший ему Objective-C. Программы на Swift компилируются при помощи LLVM, входящей в интегрированную среду разработки Xcode 6 и выше. Swift может использовать рантайм Objective-C, что делает возможным использование обоих языков (а также С) в рамках одной программы."),
                Language("TenserFlow", R.drawable.ic_tenserflow, "TensorFlow — открытая программная библиотека для машинного обучения, разработанная компанией Google для решения задач построения и тренировки нейронной сети с целью автоматического нахождения и классификации образов, достигая качества человеческого восприятия. TensorFlow применяются для исследований, так и для разработки продуктов Google. TensorFlow является продолжением закрытого проекта DistBelief. Изначально, TensorFlow была разработана командой Google Brain для внутреннего использования в Google, а потом (9 ноября 2015 года) была переведена в свободный доступ с открытой лицензией Apache 2.0.")
        )
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadLanguages()
    }

    private fun loadLanguages() {
        viewState.update(languages)
    }
}