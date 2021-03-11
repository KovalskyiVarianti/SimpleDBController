package repository.file

import entities.Clothes
import repository.Repository
import specification.ReturnableSpecification
import specification.Specification
import specification.file.*
import java.io.File

class ClothesFileRepository(var file: File = File("default.txt")) : Repository<Clothes> {

    override fun add(item: Clothes) {
        InsertFileSpecification(item).executeAlgorithm(file)
    }

    override fun remove(id: Int) {
        DeleteFileSpecification(id).executeAlgorithm(file)
    }

    override fun update(item: Clothes) {
        UpdateFileSpecification(item.id, item).executeAlgorithm(file)
    }

    override fun showAll(): List<Clothes> {
        return SelectFileSpecification().getResult(file).toClothes()
    }

    override fun <S : Specification> query(specification: S) =
        (specification as FileSpecification).executeAlgorithm(file)


    override fun <S : ReturnableSpecification> query(returnableSpecification: S): List<Clothes> =
        (returnableSpecification as FileReturnableSpecification).getResult(file).toClothes()


    private fun List<String>.toClothes(): List<Clothes> {
        val mutableList = mutableListOf<Clothes>()
        forEach {
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
