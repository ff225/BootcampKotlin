package example.myapp

import java.lang.Math.PI

/**
 * In Kotlin classi, interfacce, variabili, funzioni... possono avere diversi tipi di visibilità:
 * - public: visibile fuori dalla classe
 * - internal: visibile solo all'interno del modulo
 * - private: visibile solo all'interno della classe
 * - protected: simile a private, ma visibile all'interno della sottoclasse
 */

/**
 * Due modi per definire il metodo costruttore

class Aquarium( width: Int = 20, height: Int = 40, length: Int = 100) {
var width: Int = width
var height: Int = height
var length: Int = length
 */

/**
 * Alternativa: settiamo le proprietà direttamente tra le parentesi.
 * Occhio al VAL e VAR
 *
 *
 * Per rendere una classe sovrascrivibile dobbiamo renderla open
 * definiamo open la classe e tutte le proprietà
 */
open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    /**
     * init: utile se il nostro costrutture  ha bisogno di più codice di inizializzazione, può essere
     * inserito in uno o più blocchi di inizializzazione
     * NB: Qualsiasi proprietà utilizzata nei blocchi di inizializzazione deve essere dichiarata in precedenza.
     */
    init {
        println("Start initializzation")
    }

    open val shape = "rectangle"
    /**
     * Lo nascondiamo perché andremo una proprietà per calcolarlo.
     */
    /*
    init {
        // 1 liter = 1000 cm^3
        println("Volume: ${width * length * height / 1000} l")
    }
    */
    /**
     * Una classe Kotlin può anche avere uno o più costruttori secondari per consentire l'overload del costruttore,
     * ovvero costruttori con argomenti diversi.
     * Ogni costruttore secondario deve chiamare prima il costruttore primario, direttamente usando this(),
     * o indirettamente chiamando un altro costruttore secondario. Ciò significa che qualsiasi blocco init
     * nel costruttore primario verrà chiamato per tutti i costruttori e tutto il codice nel costruttore primario
     * verrà eseguito per primo.
     */

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
        /**
         * All'interno del costruttore secondario, mantieni la stessa lunghezza e larghezza
         * (che erano impostate nel costruttore principale) e calcola l'altezza necessaria per rendere il serbatoio
         * il volume dato.
         */
        height = (tank / (length * width)).toInt()
    }

    /**
     * getter e setter
     *
     * ricalcola il volume a seconda del valore che inseriamo in value
     */

    /**
     * Se vogliamo che  una proprietà  possa leggere o scrivere, ma che il codice esterno possa solo leggere,
     * possiamo lasciare la proprietà e il suo getter come pubblici e dichiarare il setter privato, come mostrato di seguito.
     */
    open var volume: Int
        get() = width * height * length / 1000  // 1000 cm^3 = 1 l
        set(value) {
            height = (value * 1000) / (width * length)
            /*private set(value) {
                height = (value * 1000) / (width * length)
             */
        }
    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize() {
        println(shape)
        println(
            "Width: $width cm " +
                    "Length: $length cm " +
                    "Height: $height cm "
        )

        println("Volume: $volume l Water: $water l (${water / volume * 100.0}% full)")
    }
}

class TowerTank(override var height: Int, var diameter: Int) :
    Aquarium(height = height, width = diameter, length = diameter) {
    /**
     * facciamo un override per calcolare il volume di un cilindro
     */

    override var volume: Int
        // ellipse area = π * r1 * r2
        get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }
    override var water = volume * 0.8
    override val shape = "cylinder"
}