class Cake(val size: Size, var customFrosting: Boolean = false) {
    companion object {
        fun small(): Cake {
            return Cake(Size.SMALL)
        }

        fun big(): Cake {
            return Cake(Size.BIG)
        }
    }

    enum class Size { SMALL, BIG }

    fun withCustomFrosting(): Cake {
        this.customFrosting = true
        return this
    }

    fun bakingTime(): Int {
        return if (size == Size.BIG) 3 else 2
    }

    fun decoratingTime(): Int {
        return if (customFrosting) 2 else 0
    }
}