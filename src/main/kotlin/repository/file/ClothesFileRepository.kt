package repository.file

import entities.Clothes
import entities.EntityParser
import specification.ReturnableSpecification
import specification.Specification
import specification.file.DeleteByKeyFileSpecification
import specification.file.InsertFileSpecification
import specification.file.SelectFileSpecification
import specification.file.UpdateFileSpecification
import java.io.File


class ClothesFileRepository(var file: File = File("default.txt")) : AbstractFileRepository<Clothes>() {

    override fun add(item: Clothes) {
        InsertFileSpecification(item).executeAlgorithm(file)
    }

    override fun remove(fieldName: String, fieldValue: String) {
        DeleteByKeyFileSpecification<Clothes>(fieldName to fieldValue).executeAlgorithm(file)
    }

    override fun update(item: Clothes) {
        UpdateFileSpecification(item.id, item).executeAlgorithm(file)
    }

    override fun showAll(): Collection<Clothes> {
        return SelectFileSpecification<Clothes>().getResult(file).toEntities()
    }

    override fun <S : Specification<Clothes>> query(specification: S) =
        castToFileSpec(specification).executeAlgorithm(file)

    override fun <S : ReturnableSpecification<Clothes>> query(returnableSpecification: S): Collection<Clothes> =
        castToReturnableFileSpec(returnableSpecification).getResult(file).toEntities()

    override fun List<String>.toEntities(): Collection<Clothes> = EntityParser.parseClothesCollection(this)


}
