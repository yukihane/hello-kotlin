package ch07

import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class ObservableProperty(var propValue: Int, val changeSupport: PropertyChangeSupport) {

    operator fun getValue(p: Person2, prop: KProperty<*>): Int = propValue
    operator fun setValue(p: Person2, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class Person2(val name: String, age: Int, salary: Int) : PropertyChangeAware() {

    private val observer = { prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}

fun main() {
    val p = Person2("Dmitry", 34, 2000)
    p.addPropertyChangeListener(PropertyChangeListener { event ->
        println(
            "Property ${event.propertyName} changed " + "from ${event.oldValue} to ${event.newValue}"
        )
    })
    p.age = 35
    p.salary = 2100
}