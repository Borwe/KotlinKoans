fun doSomethingWithCollection(collection: Collection<String>): Collection<String>? {

    val groupsByLength = collection.groupBy { it.length  }

    val maximumSizeOfGroup = groupsByLength.values.map { group -> group.size }.maxOrNull()

    return groupsByLength.values.firstOrNull { it.size == maximumSizeOfGroup  }
}
