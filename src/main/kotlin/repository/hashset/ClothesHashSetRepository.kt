package repository.hashset

import entities.Entity
import repository.Repository
import specification.ReturnableSpecification
import specification.Specification
import specification.hashset.*
import java.io.*

class ClothesHashSetRepository<T:Entity>(val file: File = File("hash.txt")) : Repository<T> {

    private val hashSet: HashSet<T> = if (file.exists()) {
        val objectInputStream = ObjectInputStream(FileInputStream(file.name))
        (objectInputStream.readObject() as HashSet<T>).also {
            objectInputStream.close()
        }
    } else {
        HashSet(12)
    }

    private fun updateFile() {
        val outputStream = ObjectOutputStream(FileOutputStream(file.name))
        outputStream.writeObject(hashSet)
        outputStream.close()
    }

    override fun add(item: T) {
        InsertHashSetSpecification(item).executeAlgorithm(hashSet)
        updateFile()
    }

    override fun remove(fieldName: String, fieldValue: String) {
        DeleteByKeyHashSetSpecification<T>(fieldName to fieldValue).executeAlgorithm(hashSet)
        updateFile()
    }

    override fun update(item: T) {
        UpdateHashSetSpecification(item).executeAlgorithm(hashSet)
        updateFile()
    }

    override fun showAll(): List<String> =
        SelectHashSetSpecification<T>().getResult(hashSet).also { updateFile() }


    override fun <S : Specification<T>> query(specification: S) {
        (specification as HashSetSpecification<T>).executeAlgorithm(hashSet)
        updateFile()
    }

    override fun <S : ReturnableSpecification<T>> query(returnableSpecification: S): List<String> =
        (returnableSpecification as HashSetReturnableSpecification<T>).getResult(hashSet).also { updateFile() }

}