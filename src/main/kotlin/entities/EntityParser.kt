package entities

object EntityParser {
    fun parseClothes(clothes: String):Clothes{
        val properties = clothes.split(",").map { it.trim() }
        val it = properties.iterator()
        return Clothes(
            it.next().toInt(),
            it.next(),
            it.next(),
            it.next(),
            it.next(),
            it.next(),
        )
    }

    fun parseClothesCollection(collection: Collection<String>) : List<Clothes>{
        val mutableList = mutableListOf<Clothes>()
        collection.forEach {
            val list = mutableListOf<String>()
            val matcher = "=[\\w ]+".toPattern().matcher(it)
            while (matcher.find()) {
                list.add(matcher.group().substringAfter("="))
            }
            mutableList.add(
                Clothes(
                    list[0].toInt(),
                    list[1],
                    list[2],
                    list[3],
                    list[4],
                    list[5],
                )
            )
        }
        return mutableList
    }
}