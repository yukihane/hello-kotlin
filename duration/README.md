GitHub Copilotより:

Kotlin の `Duration` クラスは `@JvmInline` アノテーションを使用しており、これは Kotlin のバリュークラス（inline class）を示します。バリュークラスは、Java から見るとその内部の単一のプロパティとして扱われます。この場合、`Duration` クラスの内部プロパティ `rawValue` は `Long` 型です。

したがって、Java から見ると、`Duration` クラスは `Long` 型として扱われます。これが、Kotlin の `Duration` が Java では `long` に見える理由です。