package repository.file

import DeleteFileSpecification
import entities.Clothes
import repository.Repository
import specification.ReturnableSpecification
import specification.Specification
import specification.file.InsertFileSpecification
import specification.file.SelectFileSpecification
import specification.file.UpdateFileSpecification
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
        val mutableList = mutableListOf<Clothes>()
        SelectFileSpecification().getResult(file).forEach { clothes ->
            val list = mutableListOf<String>()
            val matcher = "=\\w+".toPattern().matcher(clothes)
            while (matcher.find()){
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

    override fun <S> query(returnableSpecification: S): List<Clothes>
            where S : Specification,
                  S : ReturnableSpecification {
        TODO("Not yet implemented")
    }

}
