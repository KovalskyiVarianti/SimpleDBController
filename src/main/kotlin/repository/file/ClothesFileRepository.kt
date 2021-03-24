package repository.file

import entities.Entity
import repository.Repository
import specification.ReturnableSpecification
import specification.Specification
import specification.file.*
import java.io.File

class ClothesFileRepository<T:Entity>(var file: File = File("default.txt")) : Repository<T> {

    override fun add(item: T) {
        InsertFileSpecification(item).executeAlgorithm(file)
    }

    override fun remove(fieldName: String, fieldValue: String) {
        DeleteByKeyFileSpecification<T>(fieldName to fieldValue).executeAlgorithm(file)
    }

    override fun update(item: T) {
        UpdateFileSpecification(item.id, item).executeAlgorithm(file)
    }

    override fun showAll(): List<String> {
        return SelectFileSpecification<T>().getResult(file)
    }

    override fun <S : Specification<T>> query(specification: S) =
        (specification as FileSpecification<T>).executeAlgorithm(file)

    override fun <S : ReturnableSpecification<T>> query(returnableSpecification: S): List<String> =
        (returnableSpecification as FileReturnableSpecification<T>).getResult(file)


}
