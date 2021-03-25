package repository.hashset

import entities.Clothes
import entities.Entity
import repository.Repository
import specification.ReturnableSpecification
import specification.Specification
import specification.hashset.HashSetReturnableSpecification
import specification.hashset.HashSetSpecification
import java.io.*

abstract class AbstractHashSetRepository<T : Entity>(private val file: File) : Repository<T> {
    protected fun castToReturnableHashSetSpec(returnableSpecification: ReturnableSpecification<T>) =
        returnableSpecification as HashSetReturnableSpecification<T>

    protected fun castToHashSetSpec(specification: Specification<T>) =
        specification as HashSetSpecification<T>

    protected val hashSet: HashSet<Clothes> = if (file.exists()) {
        val objectInputStream = ObjectInputStream(FileInputStream(file.name))
        (objectInputStream.readObject() as HashSet<Clothes>).also {
            objectInputStream.close()
        }
    } else {
        HashSet(12)
    }

    protected fun updateFile() {
        val outputStream = ObjectOutputStream(FileOutputStream(file.name))
        outputStream.writeObject(hashSet)
        outputStream.close()
    }
}