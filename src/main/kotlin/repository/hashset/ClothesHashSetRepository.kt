package repository.hashset

import entities.Clothes
import entities.EntityParser
import specification.ReturnableSpecification
import specification.Specification
import specification.hashset.DeleteByKeyHashSetSpecification
import specification.hashset.InsertHashSetSpecification
import specification.hashset.SelectHashSetSpecification
import specification.hashset.UpdateHashSetSpecification
import java.io.File

class ClothesHashSetRepository(file: File = File("hash.txt")) : AbstractHashSetRepository<Clothes>(file) {


    override fun add(item: Clothes) {
        InsertHashSetSpecification(item).executeAlgorithm(hashSet)
        updateFile()
    }

    override fun remove(fieldName: String, fieldValue: String) {
        DeleteByKeyHashSetSpecification<Clothes>(fieldName to fieldValue).executeAlgorithm(hashSet)
        updateFile()
    }

    override fun update(item: Clothes) {
        UpdateHashSetSpecification(item).executeAlgorithm(hashSet)
        updateFile()
    }

    override fun showAll(): Collection<Clothes> =
        SelectHashSetSpecification<Clothes>().getResult(hashSet).also { updateFile() }
            .toEntities()


    override fun <S : Specification<Clothes>> query(specification: S) {
        castToHashSetSpec(specification).executeAlgorithm(hashSet)
        updateFile()
    }

    override fun <S : ReturnableSpecification<Clothes>> query(returnableSpecification: S): Collection<Clothes> =
        castToReturnableHashSetSpec(returnableSpecification).getResult(hashSet).also { updateFile() }
            .toEntities()

    override fun List<String>.toEntities(): Collection<Clothes> = EntityParser.parseClothesCollection(this)
}