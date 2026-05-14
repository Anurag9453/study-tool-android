package com.example.myapp.data.repository

import com.example.myapp.data.model.*

class HardcodedContentRepository : ContentRepository {

    override fun getClasses(): List<SchoolClass> = classes

    override fun getSubjects(section: String): List<Subject> =
        if (section == "it") itSubjects else schoolSubjects

    override fun getChapters(classId: Int, subjectId: String): List<Chapter> =
        chapters[classId to subjectId].orEmpty()

    override fun getModules(chapterId: String): List<Module> =
        modules[chapterId].orEmpty()

    override fun getModuleTitle(moduleId: String): String =
        modules.values.flatten().firstOrNull { it.id == moduleId }?.title ?: ""

    override fun getContentBlocks(moduleId: String): List<ContentBlock> =
        contentBlocks[moduleId].orEmpty()

    override fun getQuestions(moduleId: String): List<Question> =
        questions[moduleId].orEmpty()

    companion object {
        private val classes = (6..12).map { SchoolClass(id = it, displayName = "Class $it") }

        private val schoolSubjects = listOf(
            Subject(id = "maths", displayName = "Mathematics", isEnabled = true),
            Subject(id = "physics", displayName = "Physics", isEnabled = false),
            Subject(id = "chemistry", displayName = "Chemistry", isEnabled = false),
            Subject(id = "geography", displayName = "Geography", isEnabled = false),
            Subject(id = "history", displayName = "History", isEnabled = false),
        )

        private val itSubjects = listOf(
            Subject(id = "react", displayName = "React", isEnabled = true),
            Subject(id = "python", displayName = "Python", isEnabled = true),
            Subject(id = "java", displayName = "Java", isEnabled = true),
            Subject(id = "mongodb", displayName = "MongoDB", isEnabled = true),
            Subject(id = "docker", displayName = "Docker", isEnabled = true),
            Subject(id = "kubernetes", displayName = "Kubernetes", isEnabled = true),
        )

        // region Class 6 Maths Chapters
        private val chapters = mapOf(
            (6 to "maths") to listOf(
                Chapter("c6_ch1", 6, "maths", "Number System", 1),
                Chapter("c6_ch2", 6, "maths", "Fractions", 2),
                Chapter("c6_ch3", 6, "maths", "Decimals", 3),
                Chapter("c6_ch4", 6, "maths", "Basic Geometry", 4),
                Chapter("c6_ch5", 6, "maths", "Data Handling", 5),
            ),
            (7 to "maths") to listOf(
                Chapter("c7_ch1", 7, "maths", "Integers", 1),
                Chapter("c7_ch2", 7, "maths", "Fractions and Decimals", 2),
                Chapter("c7_ch3", 7, "maths", "Rational Numbers", 3),
                Chapter("c7_ch4", 7, "maths", "Simple Equations", 4),
                Chapter("c7_ch5", 7, "maths", "Lines and Angles", 5),
            ),
            (8 to "maths") to listOf(
                Chapter("c8_ch1", 8, "maths", "Rational Numbers", 1),
                Chapter("c8_ch2", 8, "maths", "Linear Equations", 2),
                Chapter("c8_ch3", 8, "maths", "Squares and Square Roots", 3),
                Chapter("c8_ch4", 8, "maths", "Exponents and Powers", 4),
                Chapter("c8_ch5", 8, "maths", "Data Handling", 5),
            ),
            (9 to "maths") to listOf(
                Chapter("c9_ch1", 9, "maths", "Number Systems", 1),
                Chapter("c9_ch2", 9, "maths", "Polynomials", 2),
                Chapter("c9_ch3", 9, "maths", "Coordinate Geometry", 3),
                Chapter("c9_ch4", 9, "maths", "Linear Equations in Two Variables", 4),
                Chapter("c9_ch5", 9, "maths", "Triangles", 5),
            ),
            (10 to "maths") to listOf(
                Chapter("c10_ch1", 10, "maths", "Real Numbers", 1),
                Chapter("c10_ch2", 10, "maths", "Polynomials", 2),
                Chapter("c10_ch3", 10, "maths", "Pair of Linear Equations", 3),
                Chapter("c10_ch4", 10, "maths", "Quadratic Equations", 4),
                Chapter("c10_ch5", 10, "maths", "Arithmetic Progressions", 5),
            ),
            (11 to "maths") to listOf(
                Chapter("c11_ch1", 11, "maths", "Sets", 1),
                Chapter("c11_ch2", 11, "maths", "Relations and Functions", 2),
                Chapter("c11_ch3", 11, "maths", "Trigonometric Functions", 3),
                Chapter("c11_ch4", 11, "maths", "Complex Numbers", 4),
                Chapter("c11_ch5", 11, "maths", "Linear Inequalities", 5),
            ),
            (12 to "maths") to listOf(
                Chapter("c12_ch1", 12, "maths", "Relations and Functions", 1),
                Chapter("c12_ch2", 12, "maths", "Inverse Trigonometric Functions", 2),
                Chapter("c12_ch3", 12, "maths", "Matrices", 3),
                Chapter("c12_ch4", 12, "maths", "Determinants", 4),
                Chapter("c12_ch5", 12, "maths", "Continuity and Differentiability", 5),
            ),
            // IT subjects use classId = 0
            (0 to "react") to listOf(
                Chapter("it_react_ch1", 0, "react", "Introduction to React", 1),
                Chapter("it_react_ch2", 0, "react", "Components & Props", 2),
                Chapter("it_react_ch3", 0, "react", "State & Hooks", 3),
                Chapter("it_react_ch4", 0, "react", "React Router", 4),
                Chapter("it_react_ch5", 0, "react", "Building Projects", 5),
            ),
            (0 to "python") to listOf(
                Chapter("it_python_ch1", 0, "python", "Introduction to Python", 1),
                Chapter("it_python_ch2", 0, "python", "Data Types & Variables", 2),
                Chapter("it_python_ch3", 0, "python", "Control Flow", 3),
                Chapter("it_python_ch4", 0, "python", "Functions & Modules", 4),
                Chapter("it_python_ch5", 0, "python", "OOP in Python", 5),
            ),
            (0 to "java") to listOf(
                Chapter("it_java_ch1", 0, "java", "Introduction to Java", 1),
                Chapter("it_java_ch2", 0, "java", "OOP Concepts", 2),
                Chapter("it_java_ch3", 0, "java", "Collections Framework", 3),
                Chapter("it_java_ch4", 0, "java", "Exception Handling", 4),
                Chapter("it_java_ch5", 0, "java", "Java Streams", 5),
            ),
            (0 to "mongodb") to listOf(
                Chapter("it_mongo_ch1", 0, "mongodb", "Introduction to MongoDB", 1),
                Chapter("it_mongo_ch2", 0, "mongodb", "CRUD Operations", 2),
                Chapter("it_mongo_ch3", 0, "mongodb", "Import & Export", 3),
                Chapter("it_mongo_ch4", 0, "mongodb", "CRUD Operations", 4),
                Chapter("it_mongo_ch5", 0, "mongodb", "MongoDB Atlas", 5),
                Chapter("it_mongo_ch6", 0, "mongodb", "Aggregation Framework", 6),
            ),
            (0 to "docker") to listOf(
                Chapter("it_docker_ch1", 0, "docker", "Introduction to Docker", 1),
                Chapter("it_docker_ch2", 0, "docker", "Docker Images", 2),
                Chapter("it_docker_ch3", 0, "docker", "Containers & Volumes", 3),
                Chapter("it_docker_ch4", 0, "docker", "Docker Compose", 4),
                Chapter("it_docker_ch5", 0, "docker", "Docker Networking", 5),
            ),
            (0 to "kubernetes") to listOf(
                Chapter("it_k8s_ch1", 0, "kubernetes", "Introduction to Kubernetes", 1),
                Chapter("it_k8s_ch2", 0, "kubernetes", "Pods & Nodes", 2),
                Chapter("it_k8s_ch3", 0, "kubernetes", "Services & Deployments", 3),
                Chapter("it_k8s_ch4", 0, "kubernetes", "ConfigMaps & Secrets", 4),
                Chapter("it_k8s_ch5", 0, "kubernetes", "Scaling & Monitoring", 5),
            ),
        )
        // endregion

        // region Class 6 - Number System modules + content
        private val modules = mapOf(
            // MongoDB - Chapter 1
            "it_mongo_ch1" to listOf(
                Module("it_mongo_ch1_m1", "it_mongo_ch1", "SQL vs NoSQL: An Introduction", 1),
                Module("it_mongo_ch1_m2", "it_mongo_ch1", "What is MongoDB?", 2),
                Module("it_mongo_ch1_m3", "it_mongo_ch1", "Documents in MongoDB", 3),
                Module("it_mongo_ch1_m4", "it_mongo_ch1", "MongoDB Ecosystem", 4),
                Module("it_mongo_ch1_m5", "it_mongo_ch1", "Replica Sets & Clusters", 5),
                Module("it_mongo_ch1_m6", "it_mongo_ch1", "Advantages of MongoDB", 6),
            ),
            // MongoDB - Chapter 2
            "it_mongo_ch2" to listOf(
                Module("it_mongo_ch2_m1", "it_mongo_ch2", "MongoDB Query Language (MQL)", 1),
                Module("it_mongo_ch2_m2", "it_mongo_ch2", "Setting up Atlas Cluster", 2),
                Module("it_mongo_ch2_m3", "it_mongo_ch2", "Installing Shell & DB Tools", 3),
                Module("it_mongo_ch2_m4", "it_mongo_ch2", "Installing MongoDB Compass", 4),
                Module("it_mongo_ch2_m5", "it_mongo_ch2", "Loading Sample Data", 5),
                Module("it_mongo_ch2_m6", "it_mongo_ch2", "Overview of MongoDB Atlas", 6),
                Module("it_mongo_ch2_m7", "it_mongo_ch2", "Connecting to Mongosh & Recap", 7),
            ),
            // MongoDB - Chapter 3
            "it_mongo_ch3" to listOf(
                Module("it_mongo_ch3_m1", "it_mongo_ch3", "Command Line Basics", 1),
                Module("it_mongo_ch3_m2", "it_mongo_ch3", "Compass: Import & Export", 2),
                Module("it_mongo_ch3_m3", "it_mongo_ch3", "Mongoimport & Mongoexport", 3),
                Module("it_mongo_ch3_m4", "it_mongo_ch3", "Mongodump & Mongorestore", 4),
            ),
            // MongoDB - Chapter 4
            "it_mongo_ch4" to listOf(
                Module("it_mongo_ch4_m1", "it_mongo_ch4", "Using find & findOne", 1),
                Module("it_mongo_ch4_m2", "it_mongo_ch4", "Querying with Data Explorer", 2),
                Module("it_mongo_ch4_m3", "it_mongo_ch4", "Case Sensitivity in MongoDB", 3),
                Module("it_mongo_ch4_m4", "it_mongo_ch4", "Creating & Deleting DBs/Collections", 4),
                Module("it_mongo_ch4_m6", "it_mongo_ch4", "Use of $ in MQL", 5),
                Module("it_mongo_ch4_m7", "it_mongo_ch4", "Comparison Operators", 6),
                Module("it_mongo_ch4_m8", "it_mongo_ch4", "Logical Operators", 7),
                Module("it_mongo_ch4_m10", "it_mongo_ch4", "Assignment: Operators", 8),
                Module("it_mongo_ch4_m9", "it_mongo_ch4", "Intro to \$expr", 9),
                Module("it_mongo_ch4_m14", "it_mongo_ch4", "Element Operators", 10),
                Module("it_mongo_ch4_m12", "it_mongo_ch4", "Cursor Methods", 11),
                Module("it_mongo_ch4_m15", "it_mongo_ch4", "Projection", 12),
                Module("it_mongo_ch4_m5", "it_mongo_ch4", "Assignment Questions", 13),
                Module("it_mongo_ch4_m13", "it_mongo_ch4", "Embedded Docs & Dot Notation", 14),
                Module("it_mongo_ch4_m11", "it_mongo_ch4", "Arrays & \$elemMatch", 15),
                Module("it_mongo_ch4_m16", "it_mongo_ch4", "Assignment Questions -2", 16),
                Module("it_mongo_ch4_m17", "it_mongo_ch4", "Insert Documents", 17),
                Module("it_mongo_ch4_m18", "it_mongo_ch4", "Delete Documents", 18),
            ),
            // MongoDB - Chapter 5
            "it_mongo_ch5" to listOf(
                Module("it_mongo_ch5_m1", "it_mongo_ch5", "Update Documents", 1),
                Module("it_mongo_ch5_m2", "it_mongo_ch5", "Upsert", 2),
                Module("it_mongo_ch5_m3", "it_mongo_ch5", "Atlas UI Update", 3),
            ),
            // MongoDB - Chapter 6
            "it_mongo_ch6" to listOf(
                Module("it_mongo_ch6_m1", "it_mongo_ch6", "Intro to Aggregation", 1),
                Module("it_mongo_ch6_m2", "it_mongo_ch6", "\$match Stage", 2),
                Module("it_mongo_ch6_m3", "it_mongo_ch6", "\$project Stage", 3),
                Module("it_mongo_ch6_m4", "it_mongo_ch6", "Assignment Questions", 4),
                Module("it_mongo_ch6_m5", "it_mongo_ch6", "Arithmetic Operators", 5),
                Module("it_mongo_ch6_m6", "it_mongo_ch6", "String Operators", 6),
                Module("it_mongo_ch6_m7", "it_mongo_ch6", "Date Operators", 7),
                Module("it_mongo_ch6_m8", "it_mongo_ch6", "Comparison Operators", 8),
                Module("it_mongo_ch6_m9",  "it_mongo_ch6", "Array Expression Operators", 9),
                Module("it_mongo_ch6_m10", "it_mongo_ch6", "Conditional Operators", 10),
                Module("it_mongo_ch6_m11", "it_mongo_ch6", "Assignment: Arrays & Conditions", 11),
                Module("it_mongo_ch6_m12", "it_mongo_ch6", "\$addFields Stage", 12),
                Module("it_mongo_ch6_m13", "it_mongo_ch6", "\$sort, \$count, \$limit, \$skip", 13),
                Module("it_mongo_ch6_m14", "it_mongo_ch6", "Assignment: addFields & Sort", 14),
                Module("it_mongo_ch6_m15", "it_mongo_ch6", "\$group Stage", 15),
                Module("it_mongo_ch6_m16", "it_mongo_ch6", "\$bucket and \$bucketAuto", 16),
                Module("it_mongo_ch6_m17", "it_mongo_ch6", "\$facet Stage", 17),
                Module("it_mongo_ch6_m18", "it_mongo_ch6", "\$sortByCount Stage", 18),
                Module("it_mongo_ch6_m19", "it_mongo_ch6", "Assignment: Group, Sort & Bucket", 19),
                Module("it_mongo_ch6_m20", "it_mongo_ch6", "\$unwind Stage", 20),
                Module("it_mongo_ch6_m21", "it_mongo_ch6", "\$out Stage", 21),
                Module("it_mongo_ch6_m22", "it_mongo_ch6", "Combining Pipeline Stages", 22),
            ),
            "c6_ch1" to listOf(
                Module("c6_ch1_m1", "c6_ch1", "What are Numbers?", 1),
                Module("c6_ch1_m2", "c6_ch1", "Place Value System", 2),
                Module("c6_ch1_m3", "c6_ch1", "Comparing Numbers", 3),
            ),
            "c6_ch2" to listOf(
                Module("c6_ch2_m1", "c6_ch2", "What is a Fraction?", 1),
                Module("c6_ch2_m2", "c6_ch2", "Types of Fractions", 2),
                Module("c6_ch2_m3", "c6_ch2", "Operations on Fractions", 3),
            ),
            "c6_ch3" to listOf(
                Module("c6_ch3_m1", "c6_ch3", "What are Decimals?", 1),
                Module("c6_ch3_m2", "c6_ch3", "Comparing Decimals", 2),
                Module("c6_ch3_m3", "c6_ch3", "Operations on Decimals", 3),
            ),
            "c6_ch4" to listOf(
                Module("c6_ch4_m1", "c6_ch4", "Points, Lines and Line Segments", 1),
                Module("c6_ch4_m2", "c6_ch4", "Angles", 2),
                Module("c6_ch4_m3", "c6_ch4", "Triangles and Quadrilaterals", 3),
            ),
            "c6_ch5" to listOf(
                Module("c6_ch5_m1", "c6_ch5", "Collecting Data", 1),
                Module("c6_ch5_m2", "c6_ch5", "Pictographs and Bar Graphs", 2),
            ),
        )
        // endregion

        // region Content blocks and questions for sample modules
        private val contentBlocks: Map<String, List<ContentBlock>> by lazy { mapOf(
            "it_mongo_ch1_m1" to listOf(
                ContentBlock.TextBlock(
                    "What is a Database and Why Do We Need It?\n\nSocho agar tumhare school mein 1000 students hain. Har student ka naam, roll number, class, marks — sab kuch ek badi copy mein likhna padta. Ek naam dhundna ho? 1000 pages palte raho! Marks update karne ho? Poori copy mein dhundho!\n\nYe problem solve karta hai — Database! Database ek organized system hai jahan data store hota hai aur instantly search, update aur retrieve kiya ja sakta hai. Chalo detail mein samjhte hain!"
                ),
                ContentBlock.TextBlock(
                    "📊 What is a SQL Database?\n\nSQL database information ko relational format mein store karta hai — matlab data tables mein hota hai, aur un tables ke beech predefined relationships hote hain. 🔗\n\nYe relational model data redundancy avoid karta hai by storing linked information in separate tables."
                ),
                ContentBlock.ExampleBlock(
                    "🛒 SQL ka real example",
                    "Maan lo ek e-commerce app hai jisme customer orders track hote hain:\n\n📋 CUSTOMER ORDERS table → order details store karta hai\n👤 CUSTOMER DETAILS table → naam, email, address store karta hai\n🏪 STORES table → store ya website info store karta hai\n\nYe teeno tables ek common field (jaise customer_id, store_id) ke through linked hote hain. 🔗\n\nJab order #1104 ki full detail chahiye, to Orders aur Customers tables ko JOIN karke data lena padta hai."
                ),
                ContentBlock.TextBlock(
                    "🚀 What is a NoSQL Database?\n\nNoSQL databases data ko non-tabular format mein store karte hain — yani tables nahi hoti! Ye SQL se bilkul alag approach hai.\n\nNoSQL ke kai types hote hain:\n\n📄 Document Databases (e.g. MongoDB) — is course ka focus\n🔑 Key-Value Databases — simplest type, har key unique hoti hai\n📐 Wide Column Databases — columns-oriented storage\n🕸️ Graph Databases — highly interrelated data ke liye"
                ),
                ContentBlock.ExampleBlock(
                    "📄 Document Database (MongoDB) ka example",
                    "MongoDB mein data JSON-jaisi documents mein store hota hai:\n\n{\n  name: \"Anurag\",\n  email: \"anurag@example.com\",\n  orders: [\n    { id: 101, item: \"Laptop\" },\n    { id: 102, item: \"Mouse\" }\n  ]\n}\n\n✅ Ek document mein multiple field-value pairs hote hain\n✅ Arrays bhi ho sakti hain\n✅ Nested documents bhi embed ho sakte hain\n\nYe documents ek Collection ke andar store hote hain. 🗂️"
                ),
                ContentBlock.TextBlock(
                    "🔑 Key-Value Database — NoSQL ka sabse simple type. Har entry ek unique key se linked hoti hai:\n  user1 → Anurag\n  user2 → Rahul\n\n🕸️ Graph Database — network data ya highly interrelated datasets ke liye use hota hai, jaise organizational hierarchies:\n  [Anurag] ── reports_to ──> [Manager]\n\n🎯 Is course mein hum specifically MongoDB (Document Database) ko detail mein cover karenge!"
                ),
            ),
            "it_mongo_ch2_m3" to listOf(
                ContentBlock.TextBlock(
                    "🛠️ Two Essential Tools — Mongo Shell & DB Tools\n\nAtlas cluster set up ho gaya, ab hume do tools install karne hain:\n\n💻 Mongo Shell (mongosh)\n   Terminal se directly Atlas cluster se baat karo\n   Queries run karo, data dekho\n\n📦 MongoDB Database Tools\n   Import/export jaisi operations ke liye\n   Bulk data handle karna\n\nDono tools ka flow:\nTerminal → Mongo Shell → Atlas Cluster\n              ↑\n          DB Tools\n          (import/export)"
                ),
                ContentBlock.ExampleBlock(
                    "🍎 Mac OS — Install Mongo Shell",
                    "1️⃣  Jaao: mongodb.com/try/download/shell\n\n2️⃣  Platform select karo:\n    → Mac OS, 64-bit version\n       (M1 chip ho to M1 bhi chalega)\n\n3️⃣  Download ho jayega → Downloads folder\n\n4️⃣  File double click karo → Extract\n\n5️⃣  Extracted folder → bin folder open karo\n\n6️⃣  bin ke andar dono files select karo\n    → Copy karo (Cmd + C)\n\n7️⃣  Hidden folders show karo:\n    → Cmd + Shift + . (dot)\n\n8️⃣  Navigate karo:\n    User → local → bin\n    (/usr/local/bin)\n\n9️⃣  Files yahan Paste karo (Cmd + V)\n\n✅ Mongo Shell install complete!"
                ),
                ContentBlock.ExampleBlock(
                    "✅ Mac — Test & Security Fix",
                    "Test karo:\n\n1️⃣  Terminal open karo:\n    Cmd + Space → \"terminal\" type karo\n\n2️⃣  Ye command type karo:\n    mongosh --help\n\n3️⃣  Agar output dikhe → ✅ Success!\n\n─────────────────────────────────\n⚠️  Mac block kare to kya karein?\n\nMac OS kabhi-kabhi unknown apps\nblock kar deta hai. Agar error aaye:\n\n1️⃣  System Preferences kholo\n       → Security & Privacy\n       → General tab\n\n2️⃣  Warning dikhegi mongosh ke baare mein\n\n3️⃣  Lock icon unlock karo (password daalo)\n\n4️⃣  \"Open Anyway\" / \"Allow Anyway\"\n    par click karo\n\n5️⃣  Dobara terminal mein test karo ✅"
                ),
                ContentBlock.ExampleBlock(
                    "🍎 Mac OS — Install Database Tools",
                    "1️⃣  mongodb.com/try/download/database-tools\n    par jaao\n\n2️⃣  Mac platform select karo → Download\n\n3️⃣  Downloads folder → bin folder open karo\n    (Is baar multiple files hongi —\n     har file ek alag task ke liye)\n    📄 mongoimport\n    📄 mongoexport\n    📄 mongodump\n    📄 mongorestore ... aur bhi\n\n4️⃣  Sabhi files copy karo\n\n5️⃣  /usr/local/bin mein paste karo\n    (same jagah jahan mongosh rakha tha)\n\n6️⃣  Test karo — terminal mein type karo:\n    mongoexport --help\n\n✅ Agar output aaye → Installation done!\n⚠️  Block kare to same security fix follow karo"
                ),
                ContentBlock.ExampleBlock(
                    "🪟 Windows — Install Mongo Shell",
                    "1️⃣  mongodb.com/try/download/shell par jaao\n\n2️⃣  Platform: Windows select karo\n    → ZIP package download karo\n       (MSI nahi, ZIP chahiye!)\n\n3️⃣  File apni desired location par save karo\n    → Example: Desktop\n\n4️⃣  Folder unzip karo → bin folder open karo\n\n5️⃣  Path copy karo:\n    Executable file par Right Click\n    → Properties → Location copy karo\n\n6️⃣  PATH variable mein add karo:\n    🔍 Windows Search → \"environment variables\"\n    → \"Edit the system environment variables\"\n    → Environment Variables button\n    → System Variables → Path → Edit\n    → New → Copied path paste karo → OK\n\n7️⃣  Test karo — CMD open karo:\n    mongosh --help\n\n✅ Commands dikhe → Setup sahi hai!\n\nPATH Variable → executable files → CMD se run"
                ),
                ContentBlock.ExampleBlock(
                    "🪟 Windows — Install Database Tools",
                    "Same process, alag download:\n\n1️⃣  mongodb.com/try/download/database-tools\n\n2️⃣  Windows version download karo → Extract karo\n\n3️⃣  bin folder ka path copy karo\n\n4️⃣  Environment Variables → Path → New\n    → Copied path paste karo → OK\n\n5️⃣  Final test — CMD mein type karo:\n    mongoexport --help\n\n✅ Valid output aaye → Sab sahi hai! 🎉\n\n─────────────────────────────────\n🏁 DONE — Dono tools install ho gaye:\n\n✅ mongosh       → Shell ready\n✅ mongoexport   → DB Tools ready\n\nKoi bhi issue ho to Q&A mein\nzaroor poochho! 🙋"
                ),
            ),
            "it_mongo_ch2_m2" to listOf(
                ContentBlock.TextBlock(
                    "☁️ Atlas Cluster Setup\n\nIs module mein hum step-by-step MongoDB Atlas par apna pehla cluster set up karenge.\n\n✅ Bilkul FREE — koi credit card nahi chahiye\n✅ 512 MB storage milegi\n✅ Training ke liye bilkul perfect\n\nSabse pehle jaao: www.mongodb.com/try 🌐"
                ),
                ContentBlock.ExampleBlock(
                    "📋 Step 1 — Sign Up & Create Account",
                    "1️⃣  mongodb.com/try par jaao\n\n2️⃣  Atlas select karo\n\n3️⃣  Right side ka form fill karo:\n    • \"How are you using MongoDB?\"\n       → \"I'm learning\" select karo\n    • Email address enter karo\n    • Personal details bharo\n    • Terms agree karo\n\n4️⃣  \"Get Started for Free\" par click karo\n\n5️⃣  📧 Email check karo\n    Verification link par click karo\n\n6️⃣  Kuch onboarding questions answer karo\n\n✅ Account ready!\n\nSign Up → Verify Email → Deploy Cluster"
                ),
                ContentBlock.ExampleBlock(
                    "🖥️ Step 2 — Deploy Cluster (Free Tier)",
                    "Cluster deploy karne ka option aayega:\n\n1️⃣  Deployment type:\n    → 🆓 Shared (FREE) select karo\n\n2️⃣  Cloud Provider & Region:\n    → Default theek hai\n    → Apne closest FREE region choose karo\n       (India ke liye: Mumbai ya Singapore)\n\n3️⃣  Cluster Tier:\n    → M0 FREE tier select karo\n    → 💾 512 MB storage\n    → No credit card!\n\n4️⃣  Cluster ka naam do:\n    → Example: \"sandbox\"\n       (training ke liye descriptive naam)\n\n5️⃣  \"Create Cluster\" par click karo\n\n⏳ Cluster deploy hone mein ~2-3 min lagte hain"
                ),
                ContentBlock.ExampleBlock(
                    "👤 Step 3 — Create Database User",
                    "Cluster ready hone ke baad kuch setup steps:\n\n📌 Left panel → \"Database Access\" → \"Add New User\"\n\n1️⃣  Username choose karo\n    → Example: user1\n\n2️⃣  Password set karo\n    → Strong password rakho! 🔐\n\n3️⃣  Privileges set karo:\n    → ⚠️ \"Atlas Admin\" select karo\n       (Ye bahut important hai!)\n\n4️⃣  \"Add User\" par click karo\n\n💡 Ye user wahi credentials hain jo tum\n   Terminal ya Compass se connect karte\n   waqt use karoge:\n\n   User → (username + password) → Atlas Cluster"
                ),
                ContentBlock.ExampleBlock(
                    "🌐 Step 4 — Allow Network Access",
                    "📌 Left panel → \"Network Access\" → \"Add IP Address\"\n\n1️⃣  \"Add IP Address\" par click karo\n\n2️⃣  IP address field mein enter karo:\n    →  0.0.0.0/0\n\n3️⃣  \"Confirm\" par click karo\n\n─────────────────────────────────\n0.0.0.0 ka matlab:\n🌍 Kisi bhi IP address se access allowed\n\n⚠️  Note: Ye sirf training ke liye hai!\nProduction mein hamesha specific\nIP addresses whitelist karo.\n─────────────────────────────────\n\n✅ Ab tum apna cluster kahi se bhi\n   access kar sakte ho!"
                ),
                ContentBlock.TextBlock(
                    "🎉 Cluster Ready — What's Next?\n\nBadhaai ho! 🥳 Tumhara Atlas account aur cluster set up ho gaya hai.\n\nAb aage ye karna hoga:\n\n🔜 Mongo Shell install karna\n   Terminal se database access ke liye\n\n🔜 MongoDB Compass install karna\n   GUI se database dekho aur manage karo\n\n🔜 Sample Data load karna\n   Practice ke liye ready-made data\n\n🔜 Interfaces ka proper overview\n   Sab kuch use karna seekhenge\n\n💡 Koi bhi problem aaye to Q&A section\n   mein zaroor poochho — hum help karenge! 🙋"
                ),
                ContentBlock.ExampleBlock(
                    "What You Built Today!",
                    "Badhai ho! Ab tumhare paas ye setup hai:\n\n[ Tumhara Computer ]\n         |\n         | (internet connection)\n         |\n         v\n[ MongoDB Atlas Cloud ]\n  Cluster: \"Sandbox\"\n  Tier:    M0 (Free Forever)\n  Nodes:   3 (Replica Set)\n  Storage: 512 MB\n\nNext steps:\n1.  mongosh install karo\n2.  Compass install karo\n3.  Connection string se connect karo\n4.  Data insert karo — aur karo practice!"
                ),
            ),
            "it_mongo_ch2_m1" to listOf(
                ContentBlock.TextBlock(
                    "💬 MQL — How to Communicate with MongoDB\n\nMongoDB ke saath communicate karne ke liye hum use karte hain:\n\n📌 MQL — Mongo Query Language\n\nMQL ek imperative language hai — matlab tum MongoDB ko directly batate ho ki kya karna hai, step by step. Ye seekhna zyada mushkil nahi hai! 😊\n\nMQL specifically simple queries ke liye design ki gayi hai jo single collections par chalti hain."
                ),
                ContentBlock.ExampleBlock(
                    "🔁 How MQL Works",
                    "MQL ka basic flow:\n\n👤 User\n    ↓  query likhta hai\n📝 MQL Query\n    ↓  MongoDB ko bhejta hai\n🍃 MongoDB\n    ↓  query execute karta hai\n📦 Result\n\nExample query (simple format mein):\ndb.customers.find({ city: \"Delhi\" })\n           ↑           ↑\n      collection     filter\n\n✅ Imperative — tum batao kya chahiye\n✅ Simple syntax\n✅ Single collection par kaam karta hai"
                ),
                ContentBlock.TextBlock(
                    "🔀 Aggregation Pipeline — For Complex Queries\n\nJab query simple na ho — jaise pehle data filter karo, phir group karo, phir sort karo — tab MQL ki jagah hum MongoDB Aggregation Pipeline use karte hain. 🚀\n\nAggregation Pipeline operations ko multiple stages mein break karta hai. Har stage pichli stage ka output le ke apna kaam karta hai — bilkul ek assembly line ki tarah! 🏭"
                ),
                ContentBlock.ExampleBlock(
                    "🏭 Aggregation Pipeline — Stage by Stage",
                    "Example: Pehle filter karo, phir group karo\n\n📥 INPUT DATA (poori collection)\n         ↓\n┌─────────────────────────┐\n│  🔍 Stage 1: FILTER     │\n│  Sirf Delhi ke customers│\n└─────────────────────────┘\n         ↓\n┌─────────────────────────┐\n│  📊 Stage 2: GROUP      │\n│  City ke hisaab se      │\n│  group karo             │\n└─────────────────────────┘\n         ↓\n📤 FINAL RESULT\n\n💡 Key rule: Stages usi order mein execute\n   hoti hain jis order mein likhi hain!\n\nAur stages:\nStage 1 → Stage 2 → Stage 3 → ... → Result"
                ),
                ContentBlock.TextBlock(
                    "🗺️ What Will We Cover in This Course?\n\n📌 MQL — Abhi cover karenge\n   Simple queries, CRUD operations,\n   single collections par kaam karna\n\n📌 Aggregation Pipeline — Baad mein\n   Complex multi-stage queries\n   Filtering + Grouping + Sorting together\n\n🎯 Dono tools milake tumhe MongoDB par\n   complete control de denge! Chalo shuru karte hain! 🚀"
                ),
            ),
            "it_mongo_ch1_m6" to listOf(
                ContentBlock.TextBlock(
                    "🏆 MongoDB Advantages — A Complete Summary\n\nIs module mein humne bahut kuch cover kiya — ab waqt hai sab kuch ek jagah consolidate karne ka. Yahan hain MongoDB ke sabse important advantages jo ise SQL se alag aur powerful banate hain! 💪"
                ),
                ContentBlock.ExampleBlock(
                    "⚔️ SQL vs MongoDB — Structure Comparison",
                    "SQL mein data alag-alag tables mein hota hai:\n\n📋 Customers Table\n        ↕ linked\n📋 Orders Table\n        ↕ linked\n📋 Stores Table\n\nEk query ke liye:\nOrders ── JOIN ── Customers ── JOIN ── Stores\n❌ Multiple tables\n❌ Complex JOINs\n❌ Zyada tables = zyada complexity\n\n─────────────────────────────────\n\nMongoDB mein sab kuch ek document mein:\n\n{\n  name: \"Anurag\",\n  orders: [\n    { id: 101 },\n    { id: 102 }\n  ]\n}\n✅ Ek query, ek document\n✅ No JOINs needed\n✅ Simple aur fast!"
                ),
                ContentBlock.ExampleBlock(
                    "🔄 Flexibility — Different Fields, Different Data Types",
                    "MongoDB mein same collection ke documents alag ho sakte hain:\n\n📄 Doc 1:\n{ name: \"Anurag\", city: \"Delhi\" }\n\n📄 Doc 2:\n{ name: \"Rahul\", phone: \"9999\" }\n← extra field, koi problem nahi! ✅\n\nEk hi field mein alag data types bhi allowed hain:\n\n📄 Doc 1: { \"value\": \"hello\" }      → String\n📄 Doc 2: { \"value\": \"2024-01-01\" } → Date\n\n✅ Embedded documents possible\n✅ Arrays possible\n✅ Mixed data types possible\n✅ Ek collection mein zyada data"
                ),
                ContentBlock.TextBlock(
                    "📝 Schemaless — Change Anytime!\n\nMongoDB schemaless hota hai — koi fixed structure nahi hoti.\n\nIska matlab:\n✅ Nayi field add karni hai? Bas likho — done!\n✅ Kisi field ki zaroorat nahi? Remove karo — no impact\n✅ Data format change karna hai? Koi migration nahi\n\nSQL mein ek naya column add karne ke liye:\n❌ Table alter karni padti hai\n❌ NULL values bhar jaati hain\n❌ Related tables impact hoti hain\n❌ Constraints check karne padte hain\n\nMongoDB mein? Seedha naya field-value pair likhdo! ✍️"
                ),
                ContentBlock.ExampleBlock(
                    "🔧 Maintenance — SQL vs MongoDB",
                    "SQL database maintain karna:\n❌ Foreign keys manage karne padte hain\n❌ Multiple tables ke beech relationships maintain karni padti hain\n❌ Schema changes complex hote hain\n❌ Constraints aur cascades handle karne padte hain\n\n─────────────────────────────────\n\nMongoDB maintain karna:\n✅ No foreign keys\n✅ No strict relationships to manage\n✅ Schema flexible hai — change easy hai\n✅ Ek document mein sab kuch → simpler queries\n\n💡 Generally MongoDB ka maintenance\n   relational databases se kaafi easy hota hai!"
                ),
                ContentBlock.ExampleBlock(
                    "📈 Horizontal Scaling — Grow as You Need",
                    "SQL → Vertical Scaling (ek server ka size badhao)\n   🖥️ Bada server → expensive, limit hoti hai\n\n─────────────────────────────────\n\nMongoDB → Horizontal Scaling (aur servers jodo)\n\nStep 1 — Shuru mein:\n🖥️ Server 1\n\nStep 2 — Data badha:\n🖥️ Server 1  +  🖥️ Server 2\n\nStep 3 — Aur badha:\n🖥️ Server 1  +  🖥️ Server 2  +  🖥️ Server 3\n                       ↓\n              🗂️ MongoDB Cluster\n\n✅ Jab chahiye add karo — easy!\n✅ Big data? No problem! 🚀\n✅ Aaj ke data demands ke liye perfect"
                ),
                ContentBlock.TextBlock(
                    "🎯 MongoDB Top Advantages — Quick Recap\n\n1️⃣  🔄  Flexible Schema\n        Alag-alag documents, alag-alag fields\n        No fixed structure\n\n2️⃣  📦  Embedded Documents & Arrays\n        Related data ek hi document mein\n        No complex JOINs\n\n3️⃣  📝  Schemaless\n        Changes karna easy\n        Evolving data ke liye perfect\n\n4️⃣  🔧  Easy Maintenance\n        No foreign keys\n        No relationship management\n\n5️⃣  📈  Horizontal Scaling\n        Cluster mein servers add karo\n        Big data easily handle hota hai\n\n🍃 Yehi wajah hai ki MongoDB aaj duniya ke\n   most popular databases mein se ek hai!"
                ),
                ContentBlock.ExampleBlock(
                    "Chapter 1 — Everything in One Place",
                    "Ye hai complete MongoDB picture jo tumne Chapter 1 mein seekha:\n\nTUMHARI APP\n    |\n    | (MongoDB Driver ya mongosh use karta hai)\n    |\n    v\nMongoDB Atlas Cluster\n    |\n    +-- Primary Node  <-- write/read hota hai yahan\n    |       |\n    |       +-- sample_training  (Database)\n    |               +-- grades      (Collection)\n    |               +-- trips       (Collection)\n    |               +-- companies   (Collection)\n    |\n    +-- Secondary Node  <-- backup\n    +-- Secondary Node  <-- backup\n\nAgar Primary fail ho → Secondary automatically\nnaya Primary ban jaata hai! (Automatic Failover)"
                ),
            ),
            "it_mongo_ch1_m5" to listOf(
                ContentBlock.TextBlock(
                    "🔁 Replica Sets — Data Safety Net\n\nMongoDB ke common deployments mein do important concepts hain — Replica Sets aur Sharded Clusters.\n\nEk Replica Set 3 machines (instances) se milkar banta hai. Teeno machines par data ka complete copy hota hai. Agar ek machine fail ho jaaye — koi tension nahi! Baaki do machines par data safe aur available rehta hai. 🛡️"
                ),
                ContentBlock.ExampleBlock(
                    "🔁 Replica Set — A Group of 3 Instances",
                    "🔁  REPLICA SET\n├── 🟢 Instance 1 — PRIMARY\n│       Writes yahan hoti hain\n│       (main machine)\n│\n├── 🔵 Instance 2 — SECONDARY\n│       Primary ka exact copy\n│       (backup #1)\n│\n└── 🔵 Instance 3 — SECONDARY\n        Primary ka exact copy\n        (backup #2)\n\n✅ Teeno mein same data hota hai\n✅ Primary fail ho to Secondary\n   automatically Primary ban jaata hai\n✅ Data kabhi lost nahi hota 🛡️"
                ),
                ContentBlock.TextBlock(
                    "🗂️ Sharded Cluster — Distribute Data, Reduce Load\n\nJab data itna zyada ho jaaye ki ek machine par fit na ho, tab Sharded Cluster use hota hai.\n\nEk Sharded Cluster multiple Replica Sets ka group hota hai. Data ko alag-alag partitions (shards) mein split kar diya jaata hai aur har shard ek alag Replica Set par store hota hai. 📦📦📦"
                ),
                ContentBlock.ExampleBlock(
                    "⚙️ Sharded Cluster ke 3 Components",
                    "Ek sharded cluster mein teen types ke components hote hain:\n\n📱  APPLICATION\n         ↓\n🔀  MONGOS  (Query Router)\n         Ye application aur\n         shards ke beech\n         traffic direct karta hai\n         ↓\n┌────────────────────┐\n├── 📦 Shard 1 (Replica Set)\n├── 📦 Shard 2 (Replica Set)\n└── 📦 Shard 3 (Replica Set)\n         ↑\n⚙️  CONFIG SERVERS\n         Metadata aur settings\n         store karte hain\n\n🔹 Shard    → data ka ek partition\n🔹 Mongos   → smart router\n🔹 Config   → cluster ka brain"
                ),
                ContentBlock.ExampleBlock(
                    "🔑 Sharding Example — Distributing Data with Shard Key",
                    "Maan lo tumhare paas millions of customers hain.\nMongoDB ek Shard Key choose karta hai data distribute karne ke liye.\n\nExample: Shard key = customer ka first name\n\nCOLLECTION (Customer Info)\n         ↓  [shard key: name]\n┌────────────────────────┐\n│ 📦 Shard 1 → A se H   │ (Anurag, Bharat, Diya...)\n│ 📦 Shard 2 → I se P   │ (Isha, Kumar, Neha...)\n│ 📦 Shard 3 → Q se Z   │ (Rahul, Vikram, Zoya...)\n└────────────────────────┘\n\n💡 Har shard apne data ka Replica Set maintain karta hai\n   → High availability + distributed storage!"
                ),
                ContentBlock.TextBlock(
                    "🏆 3 Key Benefits of MongoDB Distribution\n\n🛡️ Fault Tolerance\n   Data ke replicas alag-alag servers par hote hain.\n   Ek machine fail ho — data safe rehta hai.\n\n📈 Scalability\n   Data badhe to aur shards add karo.\n   Storage aur performance dono scale hoti hain.\n\n🌍 Data Locality — Users ke Paas Data\n   Tum data ko users ke geographically close rakh sakte ho:\n\n   🇪🇺 Users (Europe)  → Server (Europe)\n   🇺🇸 Users (America) → Server (America)\n\n   Iska faayda? Faster response time kyunki data door nahi jaata! ⚡"
                ),
            ),
            "it_mongo_ch1_m4" to listOf(
                ContentBlock.TextBlock(
                    "🌍 MongoDB Ecosystem Overview\n\nMongoDB sirf ek database nahi hai — ye ek poora ecosystem hai products aur tools ka. Is module mein hum dekhenge ki MongoDB ke paas kya-kya available hai aur hum is course mein kya use karenge.\n\nSabse pehle baat karte hain deployment options ki — yani MongoDB kahan run karega."
                ),
                ContentBlock.ExampleBlock(
                    "🖥️ On-Premises Deployment Options",
                    "Agar tum apne khud ke server par MongoDB run karna chahte ho:\n\n🏠 ON-PREMISES\n├── 🆓 Community Edition\n│       └── Free & open-source\n│           Beginners ke liye perfect\n│\n└── 🏢 Enterprise Edition\n        └── Paid version\n            Extra operational &\n            management features\n            Large organizations ke liye"
                ),
                ContentBlock.TextBlock(
                    "☁️ MongoDB Atlas — Cloud Solution\n\nAgar tum cloud par MongoDB use karna chahte ho, tab MongoDB Atlas tumhara option hai.\n\nAtlas ek fully managed cloud database solution hai — matlab tumhe server setup, maintenance, ya scaling ki chinta nahi karni! MongoDB khud sab handle karta hai. 🙌\n\nAtlas itna popular hai ki ab ye MongoDB ki total revenue ka 50% se zyada represent karta hai!"
                ),
                ContentBlock.ExampleBlock(
                    "☁️ MongoDB Atlas — Cloud Providers",
                    "Atlas in teen major cloud platforms par available hai:\n\n☁️  MONGODB ATLAS\n├── 🟠 AWS (Amazon Web Services)\n├── 🔵 Microsoft Azure\n└── 🟡 Google Cloud Platform\n\n🎓 Is course mein hum MongoDB Atlas ka FREE tier use karenge:\n   • 512 MB storage\n   • No credit card required\n   • Training ke liye bilkul kaafi!"
                ),
                ContentBlock.ExampleBlock(
                    "🛠️ MongoDB Cloud Products — Full Picture",
                    "MongoDB ke cloud mein teen main products hain:\n\n🌐  MONGODB CLOUD\n├── 🗄️  Atlas\n│       Fully managed cloud database\n│       Core product\n│\n├── 📊  Charts\n│       Database mein stored data\n│       ko visually represent karo\n│       Graphs, pie charts, dashboards\n│\n└── 📱  Realm\n        Mobile apps develop karne ke liye\n        services ka ek complete suite"
                ),
                ContentBlock.ExampleBlock(
                    "🔧 Supporting Tools — Ways to Work with MongoDB",
                    "MongoDB ke saath interact karne ke kai tarike hain:\n\n🔧  DATABASE TOOLS\n│\n├── 💻  Mongo Shell\n│       Terminal se directly MongoDB\n│       se baat karo\n│       User → Terminal → Shell → DB\n│\n├── 🔌  MongoDB Drivers\n│       Apni favorite language mein\n│       queries likho!\n│       JavaScript, Python, Java...\n│\n├── 📈  BI Connectors\n│       MongoDB ko analytics tools\n│       se connect karo\n│       QlikSense, Tableau...\n│\n└── 🧭  MongoDB Compass\n        GUI (Graphical Interface)\n        Click karke MongoDB use karo\n        User → Compass → MongoDB"
                ),
                ContentBlock.TextBlock(
                    "🎯 What Will We Use in This Course?\n\nAb tum poora ecosystem jaante ho! Is course mein primarily yahi use hoga:\n\n✅ MongoDB Atlas — humara main database (free tier)\n✅ Mongo Shell — queries likhne ke liye\n📊 MongoDB Charts — thoda cover karenge\n🔌 MongoDB Drivers — thoda cover karenge\n\n💡 Shuru karne ke liye bas ek free Atlas account chahiye — aur hum ready hain! 🚀"
                ),
            ),
            "it_mongo_ch1_m3" to listOf(
                ContentBlock.TextBlock(
                    "📋 JSON Format — The Foundation of MongoDB Documents\n\nMongoDB mein documents JSON format mein likhe jaate hain.\nJSON ka full form hai: JavaScript Object Notation 📝\n\nJSON likhne ke 5 zaroori rules:\n\n1️⃣  Document curly braces { } se start aur end hona chahiye\n2️⃣  Data key-value pairs mein hota hai\n3️⃣  Key aur value ke beech colon  :  hota hai\n4️⃣  Keys hamesha double quotes \" \" mein honi chahiye\n5️⃣  String values bhi double quotes mein, numbers bina quotes ke\n6️⃣  Alag-alag key-value pairs comma , se separate hote hain"
                ),
                ContentBlock.ExampleBlock(
                    "✍️ Valid JSON Document ka Example",
                    "{\n  \"name\": \"Anurag\",   ← string value, double quotes\n  \"age\":  25,          ← number, bina quotes\n  \"city\": \"Delhi\"      ← string value, double quotes\n}\n\n✅ Keys → double quotes mein\n✅ String values → double quotes mein\n✅ Numbers → directly likhein\n✅ Pairs → comma se separate"
                ),
                ContentBlock.TextBlock(
                    "🔑 The _id Field — Har Document ka Unique ID\n\nHar MongoDB document mein ek special field hoti hai: _id\n\n• Ye document ka unique identifier hoti hai\n• Ye hamesha populated (filled) hoti hai — kabhi empty nahi\n• Agar tum khud _id specify nahi karte, MongoDB automatically ek unique value generate kar deta hai 🤖\n• Notice karo: _id field underscore _ se start hoti hai"
                ),
                ContentBlock.ExampleBlock(
                    "🪪 _id Field ka Example",
                    "Jab tum document insert karte ho bina _id ke:\n{\n  \"name\": \"Anurag\"\n}\n\nMongoDB automatically _id add kar deta hai:\n{\n  \"_id\":  \"abc123\",   ← auto-generated! 🤖\n  \"name\": \"Anurag\"\n}\n\n💡 Tip: Tum apni khud ki _id bhi de sakte ho,\nlekin collection mein wo unique honi chahiye."
                ),
                ContentBlock.ExampleBlock(
                    "📦 Subdocuments — Document ke andar Document",
                    "Kabhi kabhi ek field ki value khud ek document hoti hai — isse Subdocument ya Embedded Document kehte hain.\n\nExample: Address ko teen parts mein store karna:\n\n{\n  \"name\": \"Anurag\",\n  \"address\": {          ← subdocument shuru\n    \"street\":   \"MG Road\",\n    \"town\":     \"Delhi\",\n    \"postcode\": \"110001\"\n  }                      ← subdocument khatam\n}\n\n✅ Subdocument bhi curly braces { } mein hota hai\n✅ Related data ek saath organize rehta hai\n✅ SQL mein ye alag table hoti — MongoDB mein same document mein!"
                ),
                ContentBlock.ExampleBlock(
                    "📋 Arrays — Ek Field, Multiple Values",
                    "Jab ek field mein multiple values store karni ho, tab array use karte hain.\nArrays square brackets [ ] mein likhte hain.\n\nExample: Customer ke 2 phone numbers:\n\n{\n  \"name\":  \"Anurag\",\n  \"phone\": [\"9999999999\", \"8888888888\"]\n             ↑                        ↑\n         pehla number           doosra number\n}\n\nArray mein mixed data types bhi ho sakte hain:\n{\n  \"mixedData\": [123, \"hello\", \"2024-01-01\"]\n                 ↑      ↑          ↑\n              number  string      date\n}"
                ),
                ContentBlock.TextBlock(
                    "⚠️ Field Names — Consistency Bahut Zaroori Hai!\n\nYaad raho: MongoDB flexible hai, lekin field names consistent rakhna tumhari zimmedari hai.\n\nGalat tarika ❌ :\nDoc 1: { \"phone\":      \"9999\" }\nDoc 2: { \"cell_phone\": \"9999\" }  ← alag naam!\n\nSahi tarika ✅ :\nDoc 1: { \"phone\": \"9999\" }\nDoc 2: { \"phone\": \"8888\" }  ← same naam\n\nAgar field names alag honge, to query karte waqt inconsistencies aayengi aur data dhundhna mushkil ho jaayega! 🔍\n\n📌 MongoDB teen main data types support karta hai:\n🔢 Numerical  — integers aur decimals\n📅 Date       — date aur time values\n🔤 String     — characters aur text\n\nAur bhi types hain — poori list official MongoDB documentation mein milegi."
                ),
            ),
            "it_mongo_ch1_m2" to listOf(
                ContentBlock.TextBlock(
                    "🍃 MongoDB ek document database hai jo data ko field-value pairs ke form mein documents ke andar store karta hai.\n\nMongoDB mein data teen levels mein organize hota hai:\n\n🏛️  DATABASE\n       ↓\n📂  COLLECTION  (jaise ek folder)\n       ↓\n📄  DOCUMENT    (jaise ek file)\n\nEk database ke andar multiple collections ho sakti hain, aur har collection ke andar multiple documents hote hain."
                ),
                ContentBlock.ExampleBlock(
                    "Almirah Analogy — An Easy Way to Remember",
                    "Socho tumhare ghar mein ek bada almirah hai:\n\n   ALMIRAH\n    (= MongoDB Database)\n    |\n    +-- Drawer 1: Students\n    |       (= Collection)\n    |       +-- Card: Rahul - Roll 1 - Delhi\n    |       +-- Card: Priya - Roll 2 - Mumbai\n    |       +-- Card: Anya - Roll 3 - Pune\n    |\n    +-- Drawer 2: Teachers\n            (= Collection)\n            +-- Card: Mr. Sharma - Maths\n            +-- Card: Ms. Gupta - Science\n\nAlmirah    = Database\nDrawer     = Collection\nCard/Form  = Document\nCard column = Field"
                ),
                ContentBlock.ExampleBlock(
                    "📄 What Does a MongoDB Document Look Like?",
                    "Ye ek customer ka document hai jisme 4 field-value pairs hain:\n\n{\n  customerId: 1,\n  name:       \"Anurag\",\n  email:      \"anurag@gmail.com\",\n  address:    \"Delhi\"\n}\n\nHar line ek field-value pair hai:\n  🔹 field  → customerId, name, email, address\n  🔹 value  → 1, \"Anurag\", \"anurag@gmail.com\", \"Delhi\""
                ),
                ContentBlock.TextBlock(
                    "🔄 Polymorphic Documents — MongoDB ki Superpower!\n\nMongoDB mein documents polymorphic hote hain — matlab same collection ke andar alag-alag structure ke documents reh sakte hain. Koi fixed schema nahi hoti! 🎉\n\nGeneral rule: ek document ke andar maximum possible related information store karo."
                ),
                ContentBlock.ExampleBlock(
                    "🆚 Do documents, same collection — alag structure",
                    "Document 1 — Anurag (phone number nahi diya):\n{\n  customerId: 1,\n  name:    \"Anurag\",\n  email:   \"anurag@gmail.com\",\n  address: \"Delhi\"\n}\n\nDocument 2 — Rahul (phone number bhi hai):\n{\n  customerId: 2,\n  name:    \"Rahul\",\n  email:   \"rahul@gmail.com\",\n  address: \"Mumbai\",\n  phone:   \"9999999999\"    ← extra field, no problem! ✅\n}\n\nDono documents same collection mein hain. Sirf isliye ki Rahul ke paas phone hai, Anurag ke document ko NULL rakhne ki zaroorat nahi! 🙌"
                ),
                ContentBlock.ExampleBlock(
                    "⚠️ How Difficult This Is in SQL",
                    "SQL mein agar phone number add karna ho, to poori table mein naya column dalna padega:\n\nID  | Name   | Email           | Address | Phone\n----|--------|-----------------|---------|----------\n 1  | Anurag | anurag@gmail.com| Delhi   | NULL ❌\n 2  | Rahul  | rahul@gmail.com | Mumbai  | 9999999999\n\nProblems:\n❌ Jahan data nahi hai wahan NULL values bhar jaati hain\n❌ Table constraints aur related tables ka impact consider karna padta hai\n❌ Jaise-jaise columns badhte hain, NULL aur redundant data bhi badhta hai"
                ),
                ContentBlock.TextBlock(
                    "✅ Why is MongoDB Better?\n\nMongoDB ki flexible nature ki wajah se:\n\n⚡ Naya field sirf us document mein add karo jisme chahiye\n⚡ Baaki documents affected nahi hote\n⚡ Koi NULL values nahi, koi extra columns nahi\n⚡ Data structure mein changes karna bahut simple hai\n\n💡 Har document sirf wahi field-value pairs rakhta hai jo usse zaroori hote hain — nothing more, nothing less!"
                ),
            ),
            "c6_ch1_m1" to listOf(
                ContentBlock.TextBlock(
                    "Numbers are all around us! We use them every day — to count things, measure distances, tell time, and much more."
                ),
                ContentBlock.TextBlock(
                    "The numbers we use for counting (1, 2, 3, 4, ...) are called Natural Numbers. When we include 0, we get Whole Numbers (0, 1, 2, 3, ...)."
                ),
                ContentBlock.ExampleBlock(
                    "Counting in daily life",
                    "There are 25 students in a class. Here, 25 is a natural number.\nA basket has 0 apples. Here, 0 is a whole number but not a natural number."
                ),
                ContentBlock.TextBlock(
                    "Natural numbers start from 1 and go on forever. There is no largest natural number — you can always add 1 more!"
                ),
            ),
            "c6_ch1_m2" to listOf(
                ContentBlock.TextBlock(
                    "The place value system helps us understand the value of each digit in a number based on its position."
                ),
                ContentBlock.TextBlock(
                    "In the number 5,432:\n• 5 is in the Thousands place (value = 5,000)\n• 4 is in the Hundreds place (value = 400)\n• 3 is in the Tens place (value = 30)\n• 2 is in the Ones place (value = 2)"
                ),
                ContentBlock.ExampleBlock(
                    "Expanded form",
                    "5,432 = 5,000 + 400 + 30 + 2\n\n83,017 = 80,000 + 3,000 + 0 + 10 + 7"
                ),
                ContentBlock.TextBlock(
                    "The Indian place value system uses periods: Ones, Thousands, Lakhs, and Crores. The International system uses Ones, Thousands, Millions, and Billions."
                ),
            ),
            "c6_ch2_m1" to listOf(
                ContentBlock.TextBlock(
                    "A fraction represents a part of a whole. When we divide something into equal parts, each part is a fraction."
                ),
                ContentBlock.TextBlock(
                    "A fraction is written as a/b where:\n• 'a' is the numerator (how many parts we have)\n• 'b' is the denominator (total equal parts)"
                ),
                ContentBlock.ExampleBlock(
                    "Pizza example",
                    "If a pizza is cut into 8 equal slices and you eat 3, you ate 3/8 of the pizza.\n\nHere, 3 is the numerator and 8 is the denominator."
                ),
                ContentBlock.TextBlock(
                    "Remember: The denominator can never be 0, because you cannot divide something into 0 equal parts!"
                ),
            ),
            "c6_ch2_m2" to listOf(
                ContentBlock.TextBlock(
                    "Fractions can be classified into different types based on the relationship between the numerator and the denominator."
                ),
                ContentBlock.TextBlock(
                    "Types of fractions:\n\n1. Proper Fraction: Numerator < Denominator (e.g., 3/4, 2/5)\n2. Improper Fraction: Numerator ≥ Denominator (e.g., 5/3, 7/4)\n3. Mixed Fraction: A whole number + a proper fraction (e.g., 2½, 3¼)"
                ),
                ContentBlock.ExampleBlock(
                    "Converting improper to mixed",
                    "7/4 → Divide 7 by 4 → Quotient = 1, Remainder = 3\nSo 7/4 = 1¾"
                ),
                ContentBlock.TextBlock(
                    "Like fractions have the same denominator (e.g., 1/5, 3/5). Unlike fractions have different denominators (e.g., 1/3, 2/5)."
                ),
            ),
            "it_mongo_ch2_m5" to listOf(
                ContentBlock.TextBlock(
                    "📦 Loading Sample Data — Course Practice Data\n\nIs module mein hum woh sample data install karenge jo hum is course ke aane wale saare modules mein use karenge.\n\nSabse easy tarika hai — Compass ke through karna! 🧭\n\nPehle humhe Atlas se apna Compass connect karna hoga."
                ),
                ContentBlock.ExampleBlock(
                    "🔌 Step 1 — Connect Compass to Atlas",
                    "1️⃣  Atlas mein login karo:\n    mongodb.com/cloud/atlas\n\n2️⃣  Apne project par navigate karo\n    (Example: \"Project Zero\")\n\n3️⃣  \"Connect\" button par click karo\n\n4️⃣  \"Connect using MongoDB Compass\"\n    select karo\n\n5️⃣  Connection string copy karo 📋\n\n─────────────────────────────────\nAtlas → Connection String → Compass\n─────────────────────────────────\n\n6️⃣  Compass open karo\n    (Mac: Finder se search karo agar\n     dock mein nahi hai)\n\n7️⃣  Connection string paste karo\n    + apna password enter karo\n\n8️⃣  Connect!\n\n✅ Ab tum cluster se connected ho!"
                ),
                ContentBlock.TextBlock(
                    "⚠️  System Databases — Do Not Delete These!\n\nConnect hone ke baad tumhe teen databases dikhenge:\n\n🔒 admin\n🔒 config\n🔒 local\n\nYe teen MongoDB ke system-generated databases hain.\nYe automatically bante hain aur internal kaam ke liye hote hain.\n\n❌ Inhe kabhi delete mat karna — cluster break ho sakta hai!"
                ),
                ContentBlock.ExampleBlock(
                    "🗄️ Step 2 — Create Sample Database & Collection",
                    "Left side panel ke neeche ek ➕ plus icon dikhega.\n\n1️⃣  Plus icon par click karo\n    → \"Create Database\" window khulega\n\n2️⃣  Database name daalo:\n    sample_training\n    (lowercase mein!)\n\n3️⃣  Collection name daalo:\n    companies\n    (lowercase mein!)\n\n4️⃣  \"Create Database\" par click karo\n\n─────────────────────────────────\n📁 Database:   sample_training\n📂 Collection: companies\n─────────────────────────────────\n\n⚠️  Naam bilkul same rakho —\n   uppercase/space galat ho jaayega!"
                ),
                ContentBlock.ExampleBlock(
                    "📥 Step 3 — Download & Import JSON Files",
                    "Lecture ke resources section se ZIP file download karo.\nDesktop par save karo → Extract/Unzip karo.\n\nsample_training folder mein 7 JSON files hongi:\n📄 companies.json\n📄 grades.json\n📄 inspections.json\n📄 routes.json\n📄 trips.json\n📄 zips.json\n📄 (+ 1 aur)\n\n─────────────────────────────────\n🔁 Har collection ke liye yahi process:\n─────────────────────────────────\n\n1️⃣  Collection par click karo\n    (e.g. companies)\n\n2️⃣  \"Add data\" → \"Import file\"\n\n3️⃣  Matching JSON file select karo\n    (companies.json for companies)\n\n4️⃣  Import complete! Documents load ✅\n\n─────────────────────────────────\ncompanies.json → companies collection\ngrades.json   → grades collection\n   ... baaki 5 bhi same tarah\n─────────────────────────────────\n\n✅ Saari 7 collections import ho gayi!"
                ),
                ContentBlock.TextBlock(
                    "🧭 Compass — Quick Overview\n\nSab data load hone ke baad Compass ka layout samjho:\n\n📌 Left Panel\n   → Cluster connections\n   → Databases list\n   → Collections list\n\n📌 Top Ribbon\n   → Database options\n   → Performance metrics\n\n📌 Main Area\n   → Collections aur Documents\n\n─────────────────────────────────\nLeft Panel  →  Databases\nTop         →  Metrics\nMain        →  Collections & Documents\n─────────────────────────────────\n\n📌 Sabse Neeche — mongosh\n\nCompass ke bottom mein mongosh (Mongo Shell) dikhega.\nIs course mein hum mainly Terminal / CMD ke through mongosh use karenge — kyunki wahan zyada operations possible hain.\n\n─────────────────────────────────\nTerminal / CMD → mongosh → MongoDB\n─────────────────────────────────\n\n🎯 Sample data ready hai — ab asli queries likhne ka time! 🔥"
                ),
            ),
            "it_mongo_ch2_m4" to listOf(
                ContentBlock.TextBlock(
                    "🧭 MongoDB Compass — View Your Database with GUI!\n\nAbhi tak humne terminal tools install kiye — Mongo Shell aur DB Tools. Ab ek aur powerful tool install karna hai:\n\n🖥️ MongoDB Compass\n   → Ek graphical interface (GUI) hai\n   → Database ko visually dekho aur manage karo\n   → Queries bhi run kar sakte ho — bina terminal ke!\n   → Beginners ke liye bahut helpful hai\n\nCompass ek window ki tarah hai jo tumhara Atlas cluster dikhata hai — seedha browser jaisa! 🌐"
                ),
                ContentBlock.ExampleBlock(
                    "🍎 Mac OS — Install Compass",
                    "1️⃣  Jaao: www.mongodb.com\n\n2️⃣  Top menu:\n    Products → Tools → Compass\n    (Ya seedha scroll karke Compass section dhundho)\n\n3️⃣  Download karo:\n    → Mac OS select karo\n    → Package download hoga (.dmg file)\n\n4️⃣  Downloaded file double click karo\n    → Ek window khulega\n\n5️⃣  MongoDB Compass icon ko\n    Applications folder mein drag karo\n\n6️⃣  Applications mein jaao → Compass open karo\n\n7️⃣  Optional: Dock mein rakhna ho to\n    → Compass icon par Right Click karo\n    → Options → Keep in Dock\n\n✅ Compass install ho gaya!\n\n─────────────────────────────────\n⚠️  Mac block kare to kya karein?\n\n1️⃣  System Preferences kholo\n    → Security & Privacy → General tab\n\n2️⃣  Compass ke baare mein warning dikhegi\n\n3️⃣  Lock icon unlock karo\n\n4️⃣  \"Allow Anyway\" par click karo\n\n5️⃣  Dobara open karo ✅"
                ),
                ContentBlock.ExampleBlock(
                    "🪟 Windows — Install Compass",
                    "1️⃣  Jaao: www.mongodb.com\n    → Products → Tools → Compass\n\n2️⃣  Windows select karo:\n    → ⚠️  MSI package download karo\n       (ZIP nahi! MSI installer chahiye)\n\n3️⃣  Downloaded .msi file par double click karo\n    → Installer window khulega\n\n4️⃣  Installation wizard follow karo:\n    → Next → Next → Install\n    → Finish\n\n5️⃣  Compass automatically open ho jaayega\n    Ya Start Menu se dhundh sakte ho\n\n✅ Windows par bhi Compass ready! 🎉"
                ),
                ContentBlock.TextBlock(
                    "🔌 Connect Compass to Atlas Cluster\n\nCompass install hone ke baad yahi steps follow karo:"
                ),
                ContentBlock.ExampleBlock(
                    "🔌 Compass — Connect to Atlas",
                    "1️⃣  Compass open karo\n    → Ek connection screen dikhega\n\n2️⃣  Atlas Dashboard mein jaao\n    → Apne cluster ke paas \"Connect\" button\n    → \"Connect using MongoDB Compass\" option\n\n3️⃣  Connection string copy karo:\n    mongodb+srv://username:password@cluster-url/database\n\n4️⃣  Compass mein connection string paste karo\n    → Apna password bhi enter karo → Connect!\n\n✅ Ab tumhara database visually dikhega —\n   collections, documents, aur sab kuch!"
                ),
            ),
            "it_mongo_ch2_m6" to listOf(
                ContentBlock.TextBlock(
                    "🌐 MongoDB Atlas — Interface Overview\n\nIs module mein hum MongoDB Atlas ka pura interface explore karenge — kahan kya milta hai, kab kya use karna hai.\n\nAtlas mein login karne ke baad pehle Organization view dikhega.\nOrganization ke andar Projects hote hain.\n\n─────────────────────────────────\nOrganization → Projects → Clusters\n─────────────────────────────────\n\nApna project \"Project Zero\" dikhega.\nIse rename karne ke liye:\n3 dots → \"Edit Project\" → naam daalo\n(Example: \"training\")"
                ),
                ContentBlock.ExampleBlock(
                    "📌 Atlas Top Menu — 3 Main Sections",
                    "Top ribbon par 3 options dikhenge:\n\n─────────────────────────────────\nTop Menu:\n├── 🗄️  Atlas    → Database (humara focus)\n├── 🧩  Realm    → App Development\n└── 📊  Charts   → Data Visualization\n─────────────────────────────────\n\n📌 Atlas\n   → Apna zyada time yahan spend karoge\n   → Cluster, databases, collections sab yahan\n\n📌 Realm\n   → Applications develop karne ke liye\n   → Is course ke scope mein nahi hai\n\n📌 Charts\n   → MongoDB data ko visually dikhata hai\n   → Graphs, pie charts, dashboards\n   → Is course mein focus nahi karenge"
                ),
                ContentBlock.ExampleBlock(
                    "🔒 Atlas Security & Connect Options",
                    "Left panel mein Security section:\n\n👤 Database Access\n   → Users create karna (jo humne kiya tha)\n   → Username + Password set karna\n\n🌐 Network Access\n   → IP addresses allow karna\n   → 0.0.0.0/0 = kahi se bhi access\n\n⚙️  Advanced Settings bhi available hain\n\n─────────────────────────────────\nConnect button se 2 options milte hain:\n─────────────────────────────────\n🖥️  mongosh (Shell)  → Terminal/CMD\n🧭  Compass (GUI)    → Visual Interface\n─────────────────────────────────\n\n📊 View Monitoring:\n   → Database performance statistics\n   → Real-time metrics"
                ),
                ContentBlock.TextBlock(
                    "🗂️ Viewing Clusters and Collections\n\nAtlas Overview par:\n\nHamare cluster mein 3 nodes hain —\nkyunki humne 3 machines ka Replica Set deploy kiya hai.\n\n─────────────────────────────────\nCluster (Replica Set)\n├── Node 1\n├── Node 2\n└── Node 3\n─────────────────────────────────\n\nCluster ke andar \"Browse Collections\" par click karo:\n\n─────────────────────────────────\nsample_training\n├── companies\n├── grades\n└── ... (baaki collections)\n─────────────────────────────────\n\nAtlas se directly in collections ko query bhi kar sakte ho!\n\n⚠️  Baaki options jaise Search, Profiler,\n   Performance Advisor, Online Archive —\n   is course mein focus nahi karenge.\n\n🎯 Hum mainly use karenge:\n   ✅ Compass (GUI)\n   ✅ mongosh (CLI / Terminal)"
                ),
            ),
            "it_mongo_ch2_m7" to listOf(
                ContentBlock.TextBlock(
                    "🔁 Everything Together — Recap!\n\nHumne kaafi saare components install kiye hain. Is module mein hum dekhenge ki ye sab ek doosre se kaise connect hote hain — ek complete picture.\n\nShuru karte hain MongoDB Atlas se. 🚀"
                ),
                ContentBlock.ExampleBlock(
                    "🌐 Atlas — Central Hub",
                    "MongoDB Atlas hamare cluster ko manage karta hai.\nAur directly databases aur collections access karne ki suvidha deta hai.\n\n─────────────────────────────────\nAtlas → Manage Cluster + View Data (GUI)\n─────────────────────────────────\n\n\"Connect\" par click karo to 2 options milte hain:\n\n─────────────────────────────────\nAtlas → Connect →\n  ├── mongosh  (Terminal / CMD)\n  └── Compass  (GUI)\n─────────────────────────────────\n\nDono tarike already setup ho chuke hain! ✅"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Connecting to mongosh via Terminal",
                    "Atlas → \"Connect\" → \"Connect to Shell\"\n\n1️⃣  Dropdown se \"mongosh\" select karo\n\n2️⃣  Connection string copy karo\n\n3️⃣  Terminal (Mac) ya CMD (Windows) open karo\n\n4️⃣  Connection string paste karo → Enter\n\n✅ Cluster se connect ho gaye!\n\n─────────────────────────────────\nTerminal → paste connection string\n         → Connected to Cluster\n─────────────────────────────────\n\n5️⃣  Test karo — type karo:\n    show dbs\n\n    → Saare databases ki list dikhegi\n    → sample_training bhi dikhega\n       (jo humne pehle banaya tha) ✅\n\n─────────────────────────────────\n6️⃣  Disconnect karna ho to:\n    exit     → MongoDB se disconnect\n    (ya terminal/CMD band kar do)\n─────────────────────────────────"
                ),
                ContentBlock.TextBlock(
                    "📦 DB Tools — For Import/Export\n\nHumne MongoDB Database Tools bhi install kiye hain:\n📄 mongoimport\n📄 mongoexport\n\nYe tools directly Terminal ya CMD ke saath connect hote hain:\n\n─────────────────────────────────\nDB Tools → Terminal → MongoDB\n          (import / export)\n─────────────────────────────────\n\nAur Compass:\n\n─────────────────────────────────\nCompass (GUI) → Cluster → Data View\n─────────────────────────────────\n\n🎯 Chapter 2 — Complete Setup Summary:\n\n✅ MQL — Query language samjhi\n✅ Atlas Cluster setup kiya (Free)\n✅ Mongo Shell (mongosh) install kiya\n✅ DB Tools install kiye (import/export)\n✅ MongoDB Compass install kiya\n✅ Sample data load kiya\n✅ Atlas interface explore kiya\n✅ mongosh se cluster connect kiya\n\nAb hum practically operations perform\nkarne ke liye ready hain! 🔥"
                ),
            ),
            "it_mongo_ch3_m1" to listOf(
                ContentBlock.TextBlock(
                    "💻 Command Line Basics — Navigating the Terminal\n\nIs module mein hum sikhenge ki terminal ya command prompt mein basic navigation commands kaise use karte hain.\n\nAgle modules mein hume terminal mein specific directories mein jaana hoga — isliye ye basics zaroori hain! 🗺️\n\n📌 Mac → Terminal use hota hai\n📌 Windows → Command Prompt (CMD) use hoti hai"
                ),
                ContentBlock.ExampleBlock(
                    "📍 pwd / cd — Where Are You?",
                    "Apni current location jaanne ke liye:\n\n🍎 Mac:\n   pwd\n   → Print Working Directory\n   → Example output: /users/malvik\n\n🪟 Windows:\n   cd\n   → Same kaam karta hai\n\n─────────────────────────────────\npwd → /users/malvik\n─────────────────────────────────\n\nFiles aur folders list karne ke liye:\n\n🍎 Mac:     ls\n🪟 Windows: dir\n\n─────────────────────────────────\nls  → folders & files list\ndir → (Windows equivalent)\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "📂 cd — Change Directory",
                    "Kisi folder mein jaane ke liye:\n\n   cd desktop\n   → Desktop folder mein chale jao\n   (Mac aur Windows dono mein same)\n\n─────────────────────────────────\ncd desktop → move into Desktop folder\n─────────────────────────────────\n\nAb desktop ke andar ls ya dir karo.\nMaan lo ek folder dikhta hai: top_folder\n\n   cd top_folder\n   → top_folder mein jaao\n\nPhir andar ls karo → sub_folder_1 dikhega\n\n   cd sub_folder_1\n\n─────────────────────────────────\nDesktop\n└── top_folder\n    └── sub_folder_1\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "⬆️ cd .. — Go Back Up",
                    "Ek level upar jaane ke liye:\n\n   cd ..\n   (do dots = parent folder)\n\n─────────────────────────────────\nsub_folder_1 → cd .. → top_folder\ntop_folder   → cd .. → Desktop\n─────────────────────────────────\n\n⚠️  Direct jump nahi kar sakte!\n\nMaan lo tum Desktop par ho aur\nsub_folder_1 mein jaana hai (2 levels neeche).\nYe seedha nahi ho sakta:\n\n   ❌  cd sub_folder_1  → Error!\n\nYe karna padega — step by step:\n\n   ✅  cd top_folder\n   ✅  cd sub_folder_1\n\n─────────────────────────────────\n💡 Ek baar mein sirf ek level\n   move kar sakte ho!\n─────────────────────────────────"
                ),
            ),
            "it_mongo_ch3_m2" to listOf(
                ContentBlock.TextBlock(
                    "🧭 Import & Export with Compass — GUI Method\n\nIs module mein hum Compass ka use karke collections import aur export karenge.\n\nYe GUI (graphical) tarika hai — bina terminal ke!\n\nPehle Atlas se connect karna hoga. 🔌\n\n─────────────────────────────────\nAtlas → Connection String → Compass → Connect\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "📤 Collection Export Karna (Compass)",
                    "1️⃣  Ek database aur collection banao:\n    Database:   import_export_DB\n    Collection: import_export_col1\n\n2️⃣  Collection mein ek document daalo:\n    \"Add Data\" → \"Insert Document\"\n    Field: value = 1\n    { \"value\": 1 }\n\n─────────────────────────────────\n3️⃣  Export karne ke liye:\n    Collection ke andar ho\n    → \"Add Data\" ke paas export icon\n    → \"Export Collection\"\n─────────────────────────────────\n\n4️⃣  Options:\n    → \"Export Full Collection\" select karo\n    → Saare fields select karo\n    → Format: JSON ya CSV\n       (Main JSON select karunga)\n    → Output location: Desktop\n    → File naam do\n    → \"Export\" par click karo\n\n✅ Export complete!\n\n─────────────────────────────────\nCollection → Export → JSON File (Desktop)\n─────────────────────────────────\n\nFile ko kisi bhi text editor mein\nopen karke document dekh sakte ho! 📄"
                ),
                ContentBlock.ExampleBlock(
                    "📥 Collection Import Karna (Compass)",
                    "Import karne ke liye pehle ek collection banana hogi:\n\n1️⃣  Plus icon → \"Create Collection\"\n    Naam: import_col\n\n2️⃣  Collection open karo\n    → Abhi empty hai\n\n─────────────────────────────────\nCollection: import_col → (empty)\n─────────────────────────────────\n\n3️⃣  Import karo:\n    \"Add Data\" → \"Import File\"\n\n4️⃣  File type: JSON select karo\n\n5️⃣  Browse karo → import_col.json select\n    → \"Import\" par click karo\n\n✅ Data import ho gaya!\n\n─────────────────────────────────\nJSON File → Import → Collection\n─────────────────────────────────\n\nImported document mein dikhega:\n{\n  \"_id\": \"...\",\n  \"value\": 2\n}\n\n💡 _id field MongoDB automatically\n   assign karta hai har document ko!"
                ),
            ),
            "it_mongo_ch3_m3" to listOf(
                ContentBlock.TextBlock(
                    "⚙️ Mongoimport & Mongoexport — Terminal Tarika\n\nCompass ke alawa hum Terminal/CMD se bhi collections import aur export kar sakte hain.\n\nIn tools ka use Atlas cluster ke saath karte hain:\n\n─────────────────────────────────\nTerminal → mongoexport / mongoimport\n         → Atlas DB\n─────────────────────────────────\n\n📌 mongoexport = Collection ko JSON file mein nikalna\n📌 mongoimport = JSON file se collection mein daalna"
                ),
                ContentBlock.ExampleBlock(
                    "🔑 What is a URI?",
                    "URI = Uniform Resource Identifier\n\nYe tumhe Atlas cluster se connect karne deta hai.\n\n─────────────────────────────────\nmongodb+srv://username:password@cluster-url/database\n─────────────────────────────────\n\nBreakdown:\n🔐 mongodb+srv://  → Secure connection\n👤 username:password → Login credentials\n🌐 @cluster-url    → Tumhara cluster address\n🗄️ /database       → Database ka naam\n─────────────────────────────────\n\nURI Atlas se milti hai:\nAtlas → Connect → Connect using Compass\n→ Connection string copy karo\n→ Database naam aur password add karo"
                ),
                ContentBlock.ExampleBlock(
                    "📤 mongoexport — Export a Collection",
                    "Syntax:\nmongoexport --uri=\"...\" --collection=... --out=...\n\n3 main options:\n📌 --uri        → Atlas cluster connect karna\n📌 --collection → Kaunsi collection export karni\n📌 --out        → File kahan save hogi\n\n─────────────────────────────────\nExample command:\nmongoexport \\\n  --uri=\"mongodb+srv://user:pass@cluster/import_export_db\"\\\n  --collection=import_export_col1 \\\n  --out=import_export_col1.json\n─────────────────────────────────\n\nSteps:\n1️⃣  Terminal open karo\n2️⃣  Desktop mein jaao:  cd Desktop\n3️⃣  Command paste karo → Enter\n\nOutput: \"exported 1 record\" ✅\n\n─────────────────────────────────\nCollection → Export → JSON File (Desktop)\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "📥 mongoimport — Import a Collection",
                    "Syntax:\nmongoimport --uri=\"...\" --collection=... --file=...\n\n3 main options:\n📌 --uri        → Connection\n📌 --collection → Jisme data dalna hai\n📌 --file       → Kaunsi JSON file import karni\n\n─────────────────────────────────\nExample command:\nmongoimport \\\n  --uri=\"mongodb+srv://user:pass@cluster/import_export_db\"\\\n  --collection=import_export_col1 \\\n  --file=import_export_col1.json\n─────────────────────────────────\n\nSteps:\n1️⃣  Pehle collection delete karo (test ke liye)\n2️⃣  Terminal mein command run karo\n3️⃣  Compass mein refresh karo\n\n✅ Collection wapas aa gayi with documents!\n\n─────────────────────────────────\nJSON File → mongoimport → Atlas Collection\n─────────────────────────────────\n\n🔥 Ek line mein yaad rakho:\nmongexport  = DB → file\nmongoimport = file → DB"
                ),
            ),
            "it_mongo_ch3_m4" to listOf(
                ContentBlock.TextBlock(
                    "🗂️ Mongodump & Mongorestore — BSON Format\n\nHumne JSON format ke tools dekhe (mongoimport/mongoexport).\nAb hum ek aur tarika dekhenge — BSON format wale tools:\n\n📌 mongodump    → Database export (BSON)\n📌 mongorestore → Database import (BSON)\n\n─────────────────────────────────\nmongoexport / mongoimport → JSON (readable)\nmongodump   / mongorestore → BSON (binary, fast)\n─────────────────────────────────\n\n❓ JSON aur BSON mein kya fark?\n\n📄 JSON — Human readable text format\n   → Analysis ke liye best\n   → Text editor mein open kar sakte ho\n\n⚡ BSON — Binary JSON\n   → Human readable NAHI hota\n   → Speed aur performance ke liye optimized\n   → Databases/clusters ke beech transfer ke liye best"
                ),
                ContentBlock.ExampleBlock(
                    "📤 mongodump — Export the Full Database",
                    "mongodump ka syntax:\nmongodump --uri=\"...\"\n\n💡 Sirf URI kaafi hai!\n   Collection ka naam nahi chahiye —\n   poora database export hota hai.\n\n─────────────────────────────────\nDatabase → mongodump → dump folder\n─────────────────────────────────\n\nSteps:\n1️⃣  Terminal open karo → Desktop par jaao\n    cd Desktop\n\n2️⃣  mongodump command paste karo → Enter\n\n3️⃣  Export complete! ✅\n\nResult:\nDesktop par ek 'dump' folder create hoga:\n\n─────────────────────────────────\ndump/\n└── import_export_db/\n    ├── collection.bson\n    └── collection.metadata.json\n─────────────────────────────────\n\n⚠️  BSON file open karoge to readable\n   nahi hogi — binary format hai!"
                ),
                ContentBlock.ExampleBlock(
                    "📥 mongorestore — Restore the Database",
                    "mongorestore ka syntax:\nmongorestore --uri=\"...\" dump/import_export_db\n\nDo cheezein chahiye:\n📌 URI → cluster connection\n📌 Path → dump folder ka path\n\n─────────────────────────────────\nExample command:\nmongorestore \\\n  --uri=\"mongodb+srv://user:pass@cluster/db\" \\\n  dump/import_export_db\n─────────────────────────────────\n\nSteps:\n1️⃣  Compass mein database delete karo\n    (\"Drop Database\" par click karo)\n\n2️⃣  Terminal mein mongorestore command run\n\n3️⃣  Compass refresh karo\n\n✅ Database wapas aa gaya! 🎉\n\n─────────────────────────────────\ndump folder → mongorestore → Atlas Database\n─────────────────────────────────"
                ),
                ContentBlock.TextBlock(
                    "🔥 Final Clarity — When to Use What?\n\n─────────────────────────────────\nmongoexport  → collection → JSON file\nmongoimport  → JSON file → collection\n\nmongodump    → database  → BSON folder\nmongorestore → BSON folder → database\n─────────────────────────────────\n\n💡 Ek line mein yaad rakho:\n\n📄 JSON  = Readable\n          → Analysis / debugging ke liye\n          → Mongoimport / Mongoexport\n\n⚡ BSON  = Fast\n          → Transfer / backup ke liye\n          → Mongodump / Mongorestore\n\n📚 Aur options chahiye?\n   MongoDB documentation dekho —\n   wahan advanced use cases bhi hain!\n\n✅ Chapter 3 Complete!"
                ),
            ),
            "it_mongo_ch4_m1" to listOf(
                ContentBlock.TextBlock(
                    "🔍 find and findOne — MongoDB's First Query Methods\n\nShell se connect karo:\nAtlas → Connect → Connect with MongoDB Shell\nConnection string copy karo → Terminal mein paste karo → Password enter karo.\n\nPhir database check karo:\n   show dbs\n   use sample_training\n   show collections"
                ),
                ContentBlock.ExampleBlock(
                    "📄 findOne() — Pehla Document Nikalo",
                    "Syntax:\ndb.collectionName.findOne(query, projection)\n\n─────────────────────────────────\ndb.collection.findOne(query, projection)\n─────────────────────────────────\n\n📌 query aur projection dono optional hain\n📌 Ek hi document return karta hai\n📌 Multiple match ho to natural order mein\n   pehla document return hota hai\n\nExample:\ndb.grades.findOne()\n→ grades collection ka pehla document milega\n\n⚠️  Case Sensitivity:\n   find → lowercase f ✅\n   One  → uppercase O ✅\n   db.grades.findOne() ✅\n\n💡 Context zaroori hai — pehle sahi\n   database mein switch karo:\n   use sample_training\n\nAdmin mein switch karo to grades nahi milega!"
                ),
                ContentBlock.ExampleBlock(
                    "🔎 find() — Multiple Documents Nikalo",
                    "Syntax:\ndb.collectionName.find(query, projection)\n\nfindOne se fark:\nfindOne → ek document\nfind    → cursor (20-20 documents)\n\n─────────────────────────────────\ndb.grades.find()\n→ 20 documents → \"type it for more\"\nit type karo → agle 20\nit type karo → agle 20 ... aur aage\n─────────────────────────────────\n\nit = iterate (cursor ko aage badhao)\n\n🎯 Filter ke saath find:\n\nSingle condition:\ndb.grades.find({'class_id': 419})\n→ sirf class 419 ke documents\n\nMultiple conditions:\ndb.grades.find({'student_id': 1, 'class_id': 270})\n→ student_id=1 AUR class_id=270\n\n─────────────────────────────────\n💡 Rules:\n• JSON syntax — curly braces mein\n• Field: double quotes mein\n• Number value: quotes ki zarurat nahi\n• Multiple conditions: comma se alag karo\n─────────────────────────────────"
                ),
            ),
            "it_mongo_ch4_m2" to listOf(
                ContentBlock.TextBlock(
                    "🖥️ Data Explorer — Run Queries with GUI\n\nShell ke alawa tum MongoDB Atlas ya Compass ke Data Explorer mein bhi queries run kar sakte ho — bina terminal ke! 🎯\n\nAtlas mein:\nApni collection par navigate karo → Documents tab → Filter box dikhega"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Atlas Data Explorer — Filter Kaise Lagaate Hain",
                    "1️⃣  Atlas mein login karo\n    → Browse Collections\n    → Apni collection select karo\n       (e.g. grades)\n\n2️⃣  Filter box mein key-value pair likho\n    (curly braces mein):\n\n    { \"class_id\": 419 }\n\n3️⃣  Apply par click karo\n\n✅ Sirf class_id 419 ke documents dikhenge!\n\n─────────────────────────────────\nYe bilkul same hai jaise shell mein:\ndb.grades.find({\"class_id\": 419})\n─────────────────────────────────\n\nMultiple conditions:\n{ \"class_id\": 270, \"student_id\": 1 }\n→ Comma se alag karo, Apply karo\n\n📌 Options button se aur bhi milta hai:\n   → Project (fields select karo)\n   → Sort    (order decide karo)\n   → Collation (language rules)"
                ),
                ContentBlock.ExampleBlock(
                    "🧭 Compass Data Explorer — Same Features, Same Method",
                    "Compass mein bhi bilkul same Data Explorer view hai:\n\n1️⃣  Compass open karo → Atlas se connect karo\n\n2️⃣  Left panel → sample_training database\n    → grades collection par click karo\n\n3️⃣  Documents view khulega\n    → Filter box dikhega\n    → Options: Project, Sort, Collation\n\n4️⃣  Filter daalo:\n    { \"class_id\": 419 }\n    → Apply / Find par click karo\n\n✅ Results wahi honge — GUI tool different\n   lekin query language same!\n\n─────────────────────────────────\nAtlas Data Explorer  →  Filter box\nCompass Data Explorer →  Filter box\nShell               →  db.col.find({})\n\nTeeno mein same JSON query syntax! 🎯\n─────────────────────────────────"
                ),
            ),
            "it_mongo_ch4_m3" to listOf(
                ContentBlock.TextBlock(
                    "⚠️ Case Sensitivity — Very Important in MongoDB!\n\nMongoDB mein saare objects case sensitive hote hain:\n\n📌 Database name — exact case\n📌 Collection name — exact case\n📌 Method name — exact case\n📌 Field names — exact case\n📌 String values — exact case\n\nEk bhi character galat hua to error! ❌\n\nSaath hi — fields ko double quotes mein likhna good practice hai, aur non-numerical values bhi."
                ),
                ContentBlock.ExampleBlock(
                    "✅ Sahi vs ❌ Galat — Case Sensitivity Examples",
                    "Collection: trips  |  Method: findOne\n\n─────────────────────────────────\n✅  db.trips.findOne()\n    → CORRECT! Sab sahi case mein\n─────────────────────────────────\n\n❌  Db.trips.findOne()\n    → GALAT! 'Db' mein uppercase D\n       db lowercase hona chahiye\n\n❌  db.Trips.findOne()\n    → GALAT! Collection 'trips' hai\n       'Trips' nahi — case matter karta hai\n\n❌  db.trips.FindOne()\n    → GALAT! Method 'findOne' hai\n       'FindOne' nahi —\n       find lowercase, One uppercase O\n─────────────────────────────────\n\n💡 Yaad rakhne ka tarika:\n   db      → hamesha lowercase\n   findOne → find(lower) + One(upper O)\n   Collection name → EXACTLY jo save kiya"
                ),
                ContentBlock.TextBlock(
                    "📝 Best Practices — When Writing Queries\n\n1️⃣  Fields ko double quotes mein likho:\n    ✅  {\"class_id\": 419}\n    ⚠️  {'class_id': 419}  (single quotes bhi chalte hain)\n\n2️⃣  Non-numerical values bhi quotes mein:\n    ✅  {\"result\": \"Violation Issued\"}\n    ❌  {\"result\": Violation Issued}\n\n3️⃣  Numbers ko quotes ki zarurat nahi:\n    ✅  {\"class_id\": 419}\n    ✅  {\"class_id\": \"419\"}  (ye string treat hoga!)\n\n4️⃣  Hamesha sahi database mein raho:\n    use sample_training → phir query karo\n\n─────────────────────────────────\n🎯 Rule of thumb:\n   Strings → quotes mein\n   Numbers → bina quotes\n   Fields  → hamesha double quotes mein\n─────────────────────────────────"
                ),
            ),
            "it_mongo_ch4_m4" to listOf(
                ContentBlock.TextBlock(
                    "🗄️ Creating & Deleting Databases & Collections\n\nTeen jagah se kar sakte ho:\n📌 Atlas (GUI — browser)\n📌 Compass (GUI — desktop app)\n📌 Shell (Terminal/CMD — commands)\n\nSabse pehle Atlas se shuru karte hain! 🚀"
                ),
                ContentBlock.ExampleBlock(
                    "🌐 Atlas and Compass — GUI Method",
                    "Atlas mein:\n1️⃣  Browse Collections par click karo\n2️⃣  \"Create Database\" par click karo\n3️⃣  Database naam: test_db\n    Collection naam: test_collection\n4️⃣  Create!\n\n💡 Capped Collection option:\n   → Tick karo to max size set hoti hai\n   → Space full hone par purane docs\n      overwrite ho jaate hain\n   → Hum ise unticked chhodte hain\n\nDelete karna:\n   → Trash icon par click karo\n   → Collection ya Database dono delete ho sakte\n   ⚠️  Agar database mein sirf ek collection hai\n      to collection delete karne par\n      database bhi delete ho jaata hai!\n\n─────────────────────────────────\nCompass mein bhi almost same process:\nCollection pe hover karo → Trash icon\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Shell — Create/Delete with Commands",
                    "Pehle connect karo:\nAtlas → Connect → Connect with MongoDB Shell\n→ Connection string paste karo → Password\n\nUseful commands:\n   show dbs          → saare databases\n   show collections  → current DB ki collections\n   use sample_training → database switch karo\n   cls               → screen clear (connection rehta hai)\n\n─────────────────────────────────\nDatabase implicitly create karna:\nuse test_db  → switched (abhi exist nahi karta)\nData ya collection daalo → tab exist karega\n─────────────────────────────────\n\nCollection create karna:\ndb.createCollection('test_col')\n   → name single quotes mein\n   → Success: { ok: 1 }\n\n⚠️  Case sensitivity:\n   db.createCollection() ✅ (c lowercase, C uppercase)\n   db.CreateCollection() ❌ (error!)\n\nCollection drop karna:\ndb.test_col.drop()\n   → true = success\n   → false = failed\n\nDatabase drop karna:\ndb.dropDatabase()\n   → Pehle sahi database mein jao!\n   → use test_db → phir db.dropDatabase()"
                ),
            ),
            "it_mongo_ch4_m5" to listOf(
                ContentBlock.TextBlock(
                    "📝 Assignment Questions — Practice Time!\n\nYe module practice ke liye hai.\nTum in queries ko khud try kar sakte ho apne Atlas cluster ke sample_training database mein.\n\nHar question mein pehle khud socho, phir solution dekho! 🧠💪"
                ),
                ContentBlock.ExampleBlock(
                    "🎯 Q1 — findOne on Inspections Collection",
                    "Question:\nShell use karo aur inspections collection pe\nfindOne method use karke ek document return karo.\n\n─────────────────────────────────\n✅ Solution:\ndb.inspections.findOne()\n─────────────────────────────────\n\nResult (example):\n{\n  _id: ObjectId('56d61033a378eccde8a83556'),\n  id: '10268-2015-CMPL',\n  certificate_number: 9304816,\n  business_name: 'UNNAMED HOT DOG VENDOR...',\n  date: 'Aug 19 2015',\n  result: 'No Violation Issued',\n  sector: 'Mobile Food Vendor - 881',\n  address: { city: '', zip: '', ... }\n}\n\n💡 Yaad rakho: findOne mein\n   find → lowercase f\n   One  → uppercase O"
                ),
                ContentBlock.ExampleBlock(
                    "🎯 Q2 & Q3 — find with Filters",
                    "Q2 (Shell):\nInspections collection mein filter karo:\n  result = 'Violation Issued'\n  sector = 'Home Improvement Contractor - 100'\n\n─────────────────────────────────\n✅ Solution:\ndb.inspections.find({\n  \"result\": \"Violation Issued\",\n  \"sector\": \"Home Improvement Contractor - 100\"\n})\n─────────────────────────────────\n\nQ3 (Atlas Data Explorer):\nInspections collection filter karo:\n  sector = 'Fuel Oil Dealer - 814'\n\n─────────────────────────────────\n✅ Solution (Filter box mein daalo):\n{ \"sector\": \"Fuel Oil Dealer - 814\" }\n→ Apply par click karo\n─────────────────────────────────\n\n💡 Atlas Data Explorer mein bhi\n   wahi JSON syntax use hota hai\n   jo Shell mein hota hai!"
                ),
            ),

            // ── Chapter 4 Module 6: Use of $ in MQL ──────────────────────────
            "it_mongo_ch4_m6" to listOf(
                ContentBlock.TextBlock(
                    "💲 Use of \$ in MQL (MongoDB Query Language)\n\nMongoDB mein \$ sign ka ek special role hai! 🎯\nYe sirf ek symbol nahi — ye MQL ka grammar hai.\n\nMQL = MongoDB Query Language\nJaise SQL databases mein SQL hoti hai,\nwaise MongoDB mein MQL use hoti hai.\n\nAb dekhte hain \$ kahan kahan aata hai! 👇"
                ),
                ContentBlock.TextBlock(
                    "📌 1. Operators ke saath \$\n\nSabse common use: Query operators\nHar operator \$ se shuru hota hai.\n\nJab tum sirf equality check karte ho:\n  {field: value}\n\nJab tum koi aur comparison karte ho:\n  {field: {\$operator: value}}\n\nOperators ke example:\n  \$gt  → greater than (zyada se)\n  \$lt  → less than (kam se)\n  \$eq  → equal to (barabar)\n  \$ne  → not equal to (barabar nahi)\n\n💡 Rule: Jab bhi special comparison chahiye,\n   \$ use karo operator ke saath!"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Example: \$ Operator Syntax",
                    "// Equality check — no \$ needed\ndb.trips.find({ \"duration seconds\": 300 })\n\n// Greater than — \$ operator\ndb.trips.find({ \"duration seconds\": { \$gt: 300 } })\n\n// Less than or equal — \$ operator\ndb.trips.find({ \"duration seconds\": { \$lte: 500 } })"
                ),
                ContentBlock.TextBlock(
                    "📌 2. Field Values mein \$\n\nKabhi kabhi \$ field ki value ko refer karta hai,\nkisi literal value ko nahi.\n\nJab dono fields ek hi document mein compare karne hon:\n  {\$expr: {\$eq: ['\$field1', '\$field2']}}\n\nYahan '\$field1' ka matlab hai:\n  \"field1 ki actual value use karo\"\n  (na ki string 'field1')"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Example: \$ for Field Reference",
                    "// Woh trips jahan start station = end station\ndb.trips.find({\n  \$expr: {\n    \$eq: [\"\$start station name\", \"\$end station name\"]\n  }\n})"
                ),
                ContentBlock.TextBlock(
                    "📌 3. Aggregation Pipeline mein \$\n\nAggregation mein \$ aur bhi zyada jagah use hota hai:\n\n  \$match   → filter documents\n  \$group   → group karo\n  \$sort    → sort karo\n  \$project → fields select karo\n  \$sum     → sum nikalo\n  \$avg     → average nikalo\n\n⚠️ Summary:\n\n  \$ before operator name → query/aggregation operator\n    Example: \$gt, \$eq, \$match, \$group\n\n  \$ before field name (in quotes) → field value reference\n    Example: '\$price', '\$start station name'\n\n  Without \$ → literal string value\n    Example: 'Violation Issued', 'New York'"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Summary: Three Uses of \$",
                    "// 1. Operator — \$ before operator keyword\n{ \"price\": { \$gt: 100 } }\n\n// 2. Field reference — \$ before field name\n{ \$expr: { \$eq: [\"\$src\", \"\$dst\"] } }\n\n// 3. Aggregation stage\ndb.sales.aggregate([\n  { \$match: { status: \"A\" } },\n  { \$group: { _id: \"\$item\", total: { \$sum: \"\$amount\" } } }\n])"
                ),
            ),

            // ── Chapter 4 Module 7: Comparison Operators ─────────────────────
            "it_mongo_ch4_m7" to listOf(
                ContentBlock.TextBlock(
                    "⚖️ Comparison Operators in MongoDB\n\nMQL mein sirf equality check nahi hoti!\nTum ranges, exclusions, aur lists ke saath bhi query kar sakte ho. 🎯\n\nSabse pehle basic syntax samjho:\n  {field: {operator: value}}\n\nJab equality ho to:\n  {field: value}  ya  {field: {\$eq: value}}\n\nAb dekho saare comparison operators! 👇"
                ),
                ContentBlock.TextBlock(
                    "📊 All Comparison Operators\n\n  \$eq  → Equal to\n         {field: {\$eq: value}}\n\n  \$ne  → Not Equal to\n         {field: {\$ne: value}}\n\n  \$gt  → Greater Than\n         {field: {\$gt: value}}\n\n  \$gte → Greater Than or Equal To\n         {field: {\$gte: value}}\n\n  \$lt  → Less Than\n         {field: {\$lt: value}}\n\n  \$lte → Less Than or Equal To\n         {field: {\$lte: value}}\n\n  \$in  → Value in Array list\n         {field: {\$in: [v1, v2, v3]}}\n\n  \$nin → Value NOT in Array list\n         {field: {\$nin: [v1, v2, v3]}}"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$gt and \$lt — Range Queries",
                    "// Trips longer than 1000 seconds\ndb.trips.find({ \"tripduration\": { \$gt: 1000 } })\n\n// Trips shorter than 500 seconds\ndb.trips.find({ \"tripduration\": { \$lt: 500 } })\n\n// Trips between 300 and 600 seconds\ndb.trips.find({\n  \"tripduration\": { \$gte: 300, \$lte: 600 }\n})"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$eq and \$ne — Equality Queries",
                    "// Companies founded exactly in 2010\ndb.companies.find({ \"founded_year\": { \$eq: 2010 } })\n// Same as:\ndb.companies.find({ \"founded_year\": 2010 })\n\n// Companies NOT founded in 2010\ndb.companies.find({ \"founded_year\": { \$ne: 2010 } })"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$in and \$nin — List Queries",
                    "// Trips where usertype is 'Subscriber' OR 'Customer'\ndb.trips.find({\n  \"usertype\": { \$in: [\"Subscriber\", \"Customer\"] }\n})\n\n// Companies NOT in 'web' or 'mobile' category\ndb.companies.find({\n  \"category_code\": { \$nin: [\"web\", \"mobile\"] }\n})"
                ),
                ContentBlock.TextBlock(
                    "💡 Tips to Remember\n\n  g = greater, l = less\n  e = equal (at the end means 'or equal to')\n  in = value list mein se koi ek\n  nin = n + in = NOT in list\n\n⚡ Pro tip:\n  Ek field pe do conditions ek saath laga sakte ho:\n  {tripduration: {\$gte: 300, \$lte: 600}}\n  → Ye find karega trips jahan 300 ≤ duration ≤ 600"
                ),
            ),

            // ── Chapter 4 Module 8: Logical Operators ────────────────────────
            "it_mongo_ch4_m8" to listOf(
                ContentBlock.TextBlock(
                    "🔗 Logical Operators in MongoDB\n\nKabhi kabhi ek condition kaafi nahi hoti.\nTum multiple conditions combine kar sakte ho! 🎯\n\nMongoDB ke 4 logical operators:\n  \$and  → Sab conditions true ho\n  \$or   → Koi ek condition true ho\n  \$nor  → Koi bhi condition true na ho\n  \$not  → Condition ko ulta kar do\n\nSyntax:\n  {\$and: [{cond1}, {cond2}, ...]}\n  {\$or:  [{cond1}, {cond2}, ...]}\n  {\$nor: [{cond1}, {cond2}, ...]}"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$and — Both Conditions Must Match",
                    "// Trips jahan usertype = 'Subscriber'\n// AUR tripduration > 600\ndb.trips.find({\n  \$and: [\n    { \"usertype\": \"Subscriber\" },\n    { \"tripduration\": { \$gt: 600 } }\n  ]\n})"
                ),
                ContentBlock.TextBlock(
                    "📌 Implicit \$and (Shorthand)\n\nJab ek hi document mein multiple conditions likho\nbina \$and ke — MongoDB automatically AND karta hai!\n\nYe dono same result dete hain:"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Explicit vs Implicit \$and",
                    "// Explicit \$and:\ndb.trips.find({\n  \$and: [\n    { \"usertype\": \"Subscriber\" },\n    { \"tripduration\": { \$gt: 600 } }\n  ]\n})\n\n// Implicit \$and (same result, shorter):\ndb.trips.find({\n  \"usertype\": \"Subscriber\",\n  \"tripduration\": { \$gt: 600 }\n})\n\n// 💡 Implicit use karo jab different fields ho\n// Explicit \$and zaroori hai jab SAME field pe\n// do conditions lagani ho"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$or — Either Condition Matches",
                    "// Trips jahan usertype = 'Subscriber'\n// YA tripduration > 600\ndb.trips.find({\n  \$or: [\n    { \"usertype\": \"Subscriber\" },\n    { \"tripduration\": { \$gt: 600 } }\n  ]\n})"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$nor — None of the Conditions Match",
                    "// Trips jahan\n// usertype NE 'Subscriber' HO\n// AUR tripduration bhi > 600 NA HO\ndb.trips.find({\n  \$nor: [\n    { \"usertype\": \"Subscriber\" },\n    { \"tripduration\": { \$gt: 600 } }\n  ]\n})"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$not — Negate a Condition",
                    "// Trips jahan tripduration 600 se zyada NAHI hai\ndb.trips.find({\n  \"tripduration\": {\n    \$not: { \$gt: 600 }\n  }\n})\n// Same result as: { tripduration: { \$lte: 600 } }"
                ),
                ContentBlock.TextBlock(
                    "💡 Key Difference: \$and vs Implicit AND\n\n  Same field, do conditions → MUST use \$and\n  Different fields → Implicit AND works fine\n\nExample (same field — MUST use \$and):\n  {\$and: [\n    {score: {\$gt: 50}},\n    {score: {\$lt: 80}}\n  ]}\n\nNote: Ye bhi ek shorthand hai:\n  {score: {\$gt: 50, \$lt: 80}}\n  (MongoDB single field pe multiple operators allow karta hai)"
                ),
            ),

            // ── Chapter 4 Module 9: Intro to \$expr ──────────────────────────
            "it_mongo_ch4_m9" to listOf(
                ContentBlock.TextBlock(
                    "🔬 Intro to \$expr\n\nAb tak humne field ko ek fixed value se compare kiya:\n  {age: {\$gt: 18}}\n\nLEKIN kya hoga agar hume ek field ko\nUsi document ke doosre field se compare karna ho? 🤔\n\nYahan aata hai → \$expr! 🎉\n\n\$expr = Expression operator\nYe allow karta hai:\n  • Ek field ko doosre field se compare karna\n  • Complex aggregation expressions use karna\n  • Field values runtime pe calculate karna"
                ),
                ContentBlock.TextBlock(
                    "📌 Syntax of \$expr\n\n  {\$expr: {<aggregation expression>}}\n\nInner aggregation expression mein:\n  • \$eq, \$gt, \$lt (aggregation versions)\n  • Field reference: '\$fieldname' (with \$ prefix)\n\n⚠️ Important:\n  \$fieldname (with \$) = field ki value refer karo\n  'fieldname' (without \$) = literal string 'fieldname'"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Basic \$expr Example",
                    "// Woh trips jahan\n// start station name = end station name\n// (round trip — same jagah se shuru aur khatam)\ndb.trips.find({\n  \$expr: {\n    \$eq: [\"\$start station name\", \"\$end station name\"]\n  }\n})"
                ),
                ContentBlock.TextBlock(
                    "🔍 How it Works\n\nHar document ke liye MongoDB check karta hai:\n  \$start station name ki value == \$end station name ki value?\n\nAgar haan → document return hoga\nAgar nahi → skip\n\nYe woh trips hain jo circular trip the —\njahan cyclist same station pe wapas aaya! 🚲"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$expr with \$gt (Greater Than)",
                    "// Woh orders jahan qty > discount\ndb.orders.find({\n  \$expr: {\n    \$gt: [\"\$qty\", \"\$discount\"]\n  }\n})\n\n// Woh employees jahan salary > target_salary\ndb.employees.find({\n  \$expr: {\n    \$gt: [\"\$salary\", \"\$target_salary\"]\n  }\n})"
                ),
                ContentBlock.TextBlock(
                    "💡 When to Use \$expr\n\n  ✅ Use \$expr when:\n     • Do fields ek hi document mein compare karne hon\n     • Dynamic comparison chahiye\n\n  ❌ Don't use \$expr when:\n     • Field ko fixed value se compare karna ho\n     • Normal comparison operators kaam kar sakte hon\n\nRemember:\n  Normal:  {field: {\$gt: 100}}\n  \$expr:   {\$expr: {\$gt: ['\$field', '\$other_field']}}"
                ),
            ),

            // ── Chapter 4 Module 10: Assignment — Operators ──────────────────
            "it_mongo_ch4_m10" to listOf(
                ContentBlock.TextBlock(
                    "📝 Assignment: Operators — Practice Time!\n\nAb tak tumne seekha:\n  • Comparison Operators (\$gt, \$lt, \$in, etc.)\n  • Logical Operators (\$and, \$or, \$nor, \$not)\n  • \$expr for field-to-field comparison\n\nAb practice karo! 💪\nHar question pehle khud solve karo,\nphir solution dekho. 🧠"
                ),
                ContentBlock.ExampleBlock(
                    "🎯 Q1 — \$in on Inspections",
                    "Question:\ninspections collection mein woh documents dhundo\njahan result field ki value in mein se koi ek ho:\n  'No Violation Issued'\n  'Violation Issued'\n\n─────────────────────────────────\n✅ Solution:\ndb.inspections.find({\n  \"result\": {\n    \$in: [\"No Violation Issued\", \"Violation Issued\"]\n  }\n})\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "🎯 Q2 — \$or Alternative for Q1",
                    "Question:\nWahi Q1 query ko \$or se likho.\n\n─────────────────────────────────\n✅ Solution:\ndb.inspections.find({\n  \$or: [\n    { \"result\": \"No Violation Issued\" },\n    { \"result\": \"Violation Issued\" }\n  ]\n})\n─────────────────────────────────\n\n💡 \$in vs \$or:\nDono same result denge jab ek hi field ki\nmultiple values check kar rahe ho.\n\$in zyada concise (chhota) hai aise cases mein!"
                ),
                ContentBlock.ExampleBlock(
                    "🎯 Q3 — \$lte + founded_year",
                    "Question:\ncompanies collection mein woh companies dhundo\njahan founded_year 2000 se kam ya barabar ho.\n\n─────────────────────────────────\n✅ Solution:\ndb.companies.find({\n  \"founded_year\": { \$lte: 2000 }\n})\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "🎯 Q4 — \$and for Same-Field Range",
                    "Question:\ncompanies collection mein woh companies dhundo\njahan employee_count:\n  100 se zyada HO\n  AUR 500 se kam HO\n\n─────────────────────────────────\n✅ Solution (Explicit \$and):\ndb.companies.find({\n  \$and: [\n    { \"number_of_employees\": { \$gt: 100 } },\n    { \"number_of_employees\": { \$lt: 500 } }\n  ]\n})\n\n✅ Alternative (Shorthand):\ndb.companies.find({\n  \"number_of_employees\": { \$gt: 100, \$lt: 500 }\n})\n─────────────────────────────────\n\n💡 Same field pe do conditions:\nDono tarike kaam karte hain!\nShorthand zyada clean lagti hai."
                ),
            ),

            // ── Chapter 4 Module 11: Arrays & $elemMatch ──────────────────────
            "it_mongo_ch4_m11" to listOf(
                ContentBlock.TextBlock(
                    "📦 Arrays & \$elemMatch in MongoDB\n\nMongoDB mein documents sirf flat fields nahi rakhte —\nwoh arrays bhi store kar sakte hain! 🎯\n\nArray ek ordered list hoti hai values ki.\nJSON mein ye square brackets [ ] se identify hoti hai.\n\nIs module mein seekhenge:\n  • Arrays ko query karna\n  • Exact array match\n  • \$all operator\n  • \$size operator\n  • Embedded docs in arrays\n  • \$elemMatch (most important!)"
                ),
                ContentBlock.TextBlock(
                    "🔍 Step 1 — Array Structure Samajhna\n\nPehle posts collection se ek document dekho.\nIs document mein tags field ek array hai."
                ),
                ContentBlock.ExampleBlock(
                    "💻 posts Collection ka Ek Document Dekho",
                    "db.posts.findOne()"
                ),
                ContentBlock.TextBlock(
                    "📋 Projection for Readability\n\nDocument bahut bada hota hai.\nSirf _id aur tags fields project karo taaki sirf array dikh sake:"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Project Only the tags Field",
                    "db.posts.find(\n  {},\n  {\n    tags: 1\n  }\n)\n\n// Result mein dekho:\n// tags: [\"current\", \"bus\", \"Ruth\", \"mile\", ...]\n// Square brackets [ ] = Ye ek array hai!"
                ),
                ContentBlock.TextBlock(
                    "🎯 Array Query Type 1 — Value Contain Karna\n\nMaan lo tume woh documents chahiye\njahan \"Ruth\" array ka koi ek element ho.\n\nSimply field = value likhte hain —\nMongoDB khud array ke andar dhundta hai!"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Array mein Single Value Query",
                    "// tags array mein \"Ruth\" ho\ndb.posts.find(\n  { tags: \"Ruth\" },\n  { tags: 1 }\n)\n\n// ✅ MongoDB automatically array ke andar check karta hai\n// Koi special syntax nahi chahiye!"
                ),
                ContentBlock.TextBlock(
                    "⚠️ Array Query Type 2 — Exact Array Match\n\nAgar tumhe exact match chahiye:\n  • Poora array same ho\n  • Same order mein ho\n\nTo value ki jagah array likhte hain:"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Exact Array Match",
                    "// Exactly [\"current\"] wale documents\ndb.posts.find({\n  tags: [\"current\"]\n})\n\n// ⚠️ Order MATTER karta hai!\n// [\"current\", \"mile\"] != [\"mile\", \"current\"]\n// Dono alag results denge!"
                ),
                ContentBlock.TextBlock(
                    "✅ Array Query Type 3 — \$all Operator\n\nKabhi kabhi tumhe chahiye ki:\n  • Do ya zyada values dono present hon\n  • Order matter na kare\n  • Extra elements allowed hon\n\nYahan aata hai \$all!"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$all Syntax & Example",
                    "// Syntax:\n// { field: { \$all: [value1, value2] } }\n\n// tags mein \"current\" AUR \"bus\" dono hon\ndb.posts.find({\n  tags: {\n    \$all: [\"current\", \"bus\"]\n  }\n})\n\n// ✅ [\"bus\", \"current\"] bhi match karega (order free)\n// ✅ [\"current\", \"bus\", \"metro\"] bhi match karega (extra ok)"
                ),
                ContentBlock.TextBlock(
                    "📏 Array Query Type 4 — \$size Operator\n\nWoh documents dhundo jahan array ka size exactly N ho.\n\nNote: \$size ke saath range query (> or <) nahi hoti.\nSirf exact number se compare hota hai."
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$size Syntax & Example",
                    "// Syntax:\n// { field: { \$size: number } }\n\n// Pehle total documents count karo\ndb.posts.find().count()\n// Result: 67485\n\n// Ab kitne documents mein tags array ka size exactly 10 hai?\ndb.posts.find({\n  tags: {\n    \$size: 10\n  }\n}).count()\n// Result: 500"
                ),
                ContentBlock.TextBlock(
                    "🧩 Embedded Documents Inside Arrays\n\nKuch arrays mein simple values nahi hoti —\nwoh poore embedded documents store karte hain!\n\nExample: grades collection mein scores field:"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Embedded Docs Array Structure",
                    "// grades collection mein ek document:\n{\n  student_id: 5,\n  scores: [\n    { type: \"exam\", score: 85 },\n    { type: \"quiz\", score: 60 },\n    { type: \"homework\", score: 72 }\n  ]\n}\n\n// scores ek array hai\n// Har element ek embedded document hai"
                ),
                ContentBlock.TextBlock(
                    "🔸 Dot Notation with Arrays\n\nEmbedded docs ko query karne ke liye dot notation:"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Dot Notation for Array Embedded Docs",
                    "// scores array ke kisi bhi element mein type = \"exam\" ho\ndb.grades.find({\n  \"scores.type\": \"exam\"\n})\n\n// ✅ MongoDB har array element check karta hai\n// Agar kisi bhi element mein type = \"exam\" ho → document return"
                ),
                ContentBlock.TextBlock(
                    "⚠️ Tricky Case — Multiple Conditions on Array\n\nAb maan lo tumhe chahiye:\n  • type = \"exam\"\n  • AUR score > 80\n  • Dono SAME embedded document mein\n\nTum soch sakte ho ye sahi hai:"
                ),
                ContentBlock.ExampleBlock(
                    "💻 ❌ Wrong Way (Galat Result Dega)",
                    "// ❌ Ye GALAT hai!\ndb.grades.find({\n  \"scores.type\": \"exam\",\n  \"scores.score\": { \$gt: 80 }\n})\n\n// Problem:\n// Ek element mein type = \"exam\" ho sakta hai\n// Aur ALAG element mein score > 80 ho sakta hai\n// MongoDB dono conditions alag alag check karega\n// → Galat documents bhi return ho sakte hain!"
                ),
                ContentBlock.TextBlock(
                    "✅ Solution — \$elemMatch\n\n\$elemMatch ensure karta hai ki:\n  Ek SINGLE array element SAARI conditions satisfy kare\n\nYe hai sabse important concept is module ka! 🎯"
                ),
                ContentBlock.ExampleBlock(
                    "💻 ✅ \$elemMatch — Correct Way",
                    "// Syntax:\n// { field: { \$elemMatch: { cond1, cond2 } } }\n\n// ✅ SAHI — SAME element mein type=exam AUR score>80\ndb.grades.find({\n  scores: {\n    \$elemMatch: {\n      type: \"exam\",\n      score: { \$gt: 80 }\n    }\n  }\n})\n\n// ⚠️ \$elemMatch case-sensitive hai\n// \"exam\" != \"Exam\""
                ),
                ContentBlock.TextBlock(
                    "📊 \$elemMatch vs Dot Notation — Key Difference\n\nWithout \$elemMatch:\n  → Conditions ALAG elements pe apply ho sakti hain\n  → Galat results possible\n\nWith \$elemMatch:\n  → Dono conditions SAME element pe apply hongi\n  → Accurate results guaranteed\n\n💡 Rule:\n  Jab array of embedded docs mein MULTIPLE conditions\n  chahiye → ALWAYS use \$elemMatch!"
                ),
            ),

            // ── Chapter 4 Module 12: Cursor Methods ──────────────────────────
            "it_mongo_ch4_m12" to listOf(
                ContentBlock.TextBlock(
                    "🖱️ Cursor Methods in MongoDB\n\nJab tum find() run karte ho, MongoDB ek cursor return karta hai.\nCursor pe kuch methods chain kar sakte ho! 🔗\n\nIs module mein 5 main cursor methods:\n  • count()  → kitne documents?\n  • sort()   → kaunse order mein?\n  • limit()  → kitne return karo?\n  • skip()   → pehle X skip karo\n  • size()   → after limit/skip kitne bache?"
                ),
                ContentBlock.TextBlock(
                    "1️⃣ count() Method\n\nResult set mein return hue documents ki count deta hai.\nSimply .count() find() ke baad chain karo."
                ),
                ContentBlock.ExampleBlock(
                    "💻 count() — Examples",
                    "// Syntax:\n// db.collection.find().count()\n\n// trips collection mein total documents:\ndb.trips.find().count()\n// Result: 10000\n\n// 300 seconds se zyada wali trips:\ndb.trips.find({\n  tripduration: { \$gt: 300 }\n}).count()\n// Result: 7976\n\n// 300 se zyada AUR 400 se kam:\ndb.trips.find({\n  tripduration: { \$gt: 300, \$lt: 400 }\n}).count()\n// Result: 1214"
                ),
                ContentBlock.TextBlock(
                    "2️⃣ sort() Method\n\nDocuments ko order karta hai ek ya zyada fields ke basis pe.\n\n  1  → Ascending (A→Z, 0→9, oldest first)\n  -1 → Descending (Z→A, 9→0, newest first)\n\nStrings → alphabetically sort\nNumbers → numerically sort\nDates → date order mein sort"
                ),
                ContentBlock.ExampleBlock(
                    "💻 sort() — Single Field",
                    "// Syntax:\n// db.collection.find().sort({ field: 1/-1 })\n\n// start_station_name ke basis pe descending sort\ndb.trips.find().sort({\n  start_station_name: -1\n})\n\n// tripduration ascending sort (300-400 range)\ndb.trips.find({\n  tripduration: { \$gt: 300, \$lt: 400 }\n}).sort({\n  tripduration: 1\n})\n// Result: 301, 302, 303 ... (lowest first)"
                ),
                ContentBlock.ExampleBlock(
                    "💻 sort() — Multiple Fields",
                    "// Pehle start_station_name ascending\n// Phir us station ke andar tripduration descending\ndb.trips.find().sort({\n  start_station_name: 1,\n  tripduration: -1\n})\n\n// Result:\n// → Stations A-Z order mein\n// → Har station ke andar longest trip pehle\n// → Phir gradually shorter trips\n// → Phir next station start"
                ),
                ContentBlock.TextBlock(
                    "3️⃣ limit() Method\n\nSirf N number of documents return karta hai.\n\n💡 Pro tip: limit(1) basically findOne() jaisa kaam karta hai!\n\n⚠️ Note: MongoDB shell ek baar mein sirf 20 documents return karta hai.\nAgle 20 ke liye shell mein 'it' type karo."
                ),
                ContentBlock.ExampleBlock(
                    "💻 limit() — Examples",
                    "// Syntax:\n// db.collection.find().limit(number)\n\n// Sirf 1 document (findOne jaisa)\ndb.trips.find().limit(1)\n\n// Sirf 5 documents\ndb.trips.find().limit(5)\n\n// Shell reminder:\n// Ek baar mein sirf 20 documents aate hain\n// Agle batch ke liye type karo:\nit"
                ),
                ContentBlock.TextBlock(
                    "4️⃣ skip() Method\n\nPehle X documents skip karta hai, phir baaki return karta hai.\nPagination implement karne ke kaam aata hai.\n\n5️⃣ size() Method\n\nResult set ka size return karta hai.\nCount() se fark: size() skip()/limit() ke baad bhi accurate hota hai."
                ),
                ContentBlock.ExampleBlock(
                    "💻 skip() aur size() — Examples",
                    "// skip() syntax:\n// db.collection.find().skip(number)\n\n// Pehle 10 documents skip karo\ndb.trips.find().skip(10)\n\n// size() — limit ke baad use karo\ndb.trips.find().limit(5).size()\n// Result: 5\n\n// count() vs size() difference:\ndb.trips.find().limit(5).count()  // Result: 5\ndb.trips.find().limit(5).size()   // Result: 5\n// Note: size() limit/skip ke saath zyada accurate hai"
                ),
                ContentBlock.TextBlock(
                    "📊 Quick Reference — All Cursor Methods\n\n  .count()       → Total matching documents\n  .sort({f: 1})  → Ascending sort\n  .sort({f: -1}) → Descending sort\n  .limit(N)      → Sirf N documents return karo\n  .skip(N)       → Pehle N documents skip karo\n  .size()        → After limit/skip ka size\n\n💡 Chain kar sakte ho:\n  find().sort({...}).limit(10).skip(5)\n\n🖥️ Atlas GUI mein bhi sort aur filter options milte hain\n   find ribbon ke andar — bilkul shell jaisi functionality!"
                ),
            ),

            // ── Chapter 4 Module 13: Embedded Docs & Dot Notation ────────────
            "it_mongo_ch4_m13" to listOf(
                ContentBlock.TextBlock(
                    "🔗 Embedded Documents & Dot Notation\n\nMongoDB mein documents ke andar aur documents ho sakte hain!\nInhe Embedded Documents kehte hain. 📄\n\nYe curly braces { } mein enclosed hote hain\naur kisi field ki value hote hain."
                ),
                ContentBlock.ExampleBlock(
                    "💻 Embedded Document Structure",
                    "// inspections collection ka ek document:\ndb.inspections.findOne()\n\n// address field ek embedded document hai:\n{\n  _id: ObjectId('...'),\n  result: \"No Violation Issued\",\n  address: {\n    zip: 11427,\n    city: \"Queens\"\n  }\n}\n\n// address ke andar:\n//   zip  → nested field\n//   city → nested field"
                ),
                ContentBlock.TextBlock(
                    "❌ Wrong Way — Direct Field Access\n\nAgar tum zip field ko directly query karo\n(bina address ke), koi result nahi milega.\n\nKyunki: zip top-level field nahi hai —\nwoh address ke andar nested hai!"
                ),
                ContentBlock.ExampleBlock(
                    "💻 ❌ Wrong Way",
                    "// ❌ Ye kaam NAHI karega\ndb.inspections.find({\n  zip: 11427\n})\n// Result: empty (koi document nahi)\n\n// Kyun? zip top-level pe exist nahi karta\n// Woh address.zip hai!"
                ),
                ContentBlock.TextBlock(
                    "✅ Correct Way — Dot Notation\n\nEmbedded fields ko query karne ka sahi tarika:\n  \"parent.child\"\n\nDot (.) se parent aur child field separate hote hain.\nPoori string quotes mein honi chahiye!"
                ),
                ContentBlock.ExampleBlock(
                    "💻 ✅ Dot Notation se Embedded Field Query",
                    "// ✅ Sahi tarika — dot notation\ndb.inspections.find({\n  \"address.zip\": 11427\n})\n// Ab query kaam karegi!\n\n// Structure:\n// address → top-level field\n// .zip    → next-level field\n// \"address.zip\" → exact path"
                ),
                ContentBlock.TextBlock(
                    "🌊 Multi-Level Nesting\n\nNesting aur bhi deep ho sakti hai.\nHar level dot se separate hoti hai."
                ),
                ContentBlock.ExampleBlock(
                    "💻 Multi-Level Dot Notation",
                    "// 3 levels deep document:\n{\n  address: {\n    zip: {\n      code: \"11427-A\"\n    }\n  }\n}\n\n// Query for 3 levels:\ndb.inspections.find({\n  \"address.zip.code\": \"11427-A\"\n})\n\n// General patterns:\n// \"parent.child\"              → 2 levels\n// \"parent.child.grandchild\"  → 3 levels"
                ),
                ContentBlock.TextBlock(
                    "📌 More Real-World Examples\n\nDot notation kaafi jagah kaam aata hai.\nYahan kuch common patterns hain:"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Dot Notation — More Examples",
                    "// Example 1: customer city query\n// Document structure:\n// { customer: { city: \"Delhi\" } }\ndb.orders.find({\n  \"customer.city\": \"Delhi\"\n})\n\n// Example 2: payment method query\n// Document structure:\n// { payment: { method: \"Card\" } }\ndb.orders.find({\n  \"payment.method\": \"Card\"\n})\n\n// Example 3: result field (top-level — no dot needed)\ndb.inspections.find({\n  result: \"No Violation Issued\"\n})"
                ),
                ContentBlock.TextBlock(
                    "⚠️ Important Rules Summary\n\n  ❌ Wrong: { zip: 11427 }\n     (Jab field embedded ho)\n\n  ✅ Correct: { \"address.zip\": 11427 }\n     (Dot notation use karo)\n\n  ✅ Correct: { result: \"Pass\" }\n     (Jab field top-level ho)\n\n💡 Key Rule:\n  Jab bhi field kisi doosre field ke andar nested ho,\n  dot notation (\"parent.child\") use karo.\n  Top-level fields ke liye direct naam use karo."
                ),
            ),

            // ── Chapter 4 Module 14: Element Operators ────────────────────────
            "it_mongo_ch4_m14" to listOf(
                ContentBlock.TextBlock(
                    "🧬 Element Operators — \$exists & \$type\n\nKabhi kabhi tumhe check karna hota hai:\n  • Kya field document mein hai ya nahi?\n  • Field ki value ka data type kya hai?\n\nYe dono kaam karte hain Element Operators:\n  \$exists → Field present hai ya nahi\n  \$type  → Field ka BSON data type kya hai"
                ),
                ContentBlock.TextBlock(
                    "🔎 \$exists Operator\n\n\$exists check karta hai ki koi field document mein exist karta hai ya nahi.\n\n  true  → field present hai wale documents laao\n  false → field missing hai wale documents laao"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$exists Syntax & Examples",
                    "// Syntax:\n// { field: { \$exists: true/false } }\n\n// Example 1: Sirf woh companies jahan IPO field HO\ndb.companies.find({\n  IPO: { \$exists: true }\n})\n// → Saare returned documents mein IPO field hoga\n\n// Example 2: Sirf woh companies jahan funding_rounds field NA HO\ndb.companies.find({\n  funding_rounds: { \$exists: false }\n})\n// → Saare returned documents mein funding_rounds nahi hoga\n\n// Example 3: Combine karo — IPO hai AUR funding_rounds bhi hai\ndb.companies.find({\n  IPO: { \$exists: true },\n  funding_rounds: { \$exists: true }\n})"
                ),
                ContentBlock.TextBlock(
                    "🗂️ \$type Operator\n\n\$type check karta hai ki field ki value\nkis BSON data type ki hai.\n\nBSON = Binary JSON\nMongoDB internally data BSON format mein store karta hai.\n\nHar data type ka ek numeric code hota hai:"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Common BSON Type Codes",
                    "// BSON Type  →  Code\n// ──────────────────\n// Double     →   1\n// String     →   2\n// Object     →   3\n// Array      →   4\n// Boolean    →   8\n// Null       →  10\n// Integer    →  16\n\n// Syntax:\n// { field: { \$type: <BSON_Code> } }"
                ),
                ContentBlock.ExampleBlock(
                    "💻 \$type — Practical Examples",
                    "// Example 1: homepage_url STRING ho (code=2)\ndb.companies.find({\n  homepage_url: { \$type: 2 }\n})\n// → Sirf woh documents jahan homepage_url ek string hai\n\n// Example 2: homepage_url NULL ho (code=10)\ndb.companies.find({\n  homepage_url: { \$type: 10 }\n})\n// → Sirf woh documents jahan homepage_url = null\n\n// Example 3: Multiple conditions combine karo\ndb.companies.find({\n  homepage_url: { \$type: 2 },\n  founded_year: { \$type: 10 }\n})\n// → homepage_url string HAI + founded_year null HAI"
                ),
                ContentBlock.TextBlock(
                    "⚠️ Important Difference — null vs \$exists\n\nYe bahut important concept hai! 🎯\n\n{ age: null }\n→ Match karega dono:\n  • Documents jahan age = null ho\n  • Documents jahan age field MISSING ho\n\n{ age: { \$exists: true } }\n→ Match karega sirf:\n  • Documents jahan age field present ho\n  (null bhi, koi bhi value bhi)\n\n✅ Combined use — Most Precise:\n{ age: { \$exists: true, \$eq: null } }\n→ Match karega sirf:\n  • Field present HO\n  • AUR value null HO"
                ),
                ContentBlock.ExampleBlock(
                    "💻 null vs \$exists — Side by Side",
                    "// Case 1: age = null (broad match)\n{ age: null }\n// Matches: { age: null } ✅\n// Matches: { name: \"Ali\" }  ✅ (age field missing)\n\n// Case 2: \$exists: true\n{ age: { \$exists: true } }\n// Matches: { age: null }    ✅\n// Matches: { age: 25 }     ✅\n// Skips:   { name: \"Ali\" } ❌ (age field missing)\n\n// Case 3: Precise null check\n{ age: { \$exists: true, \$eq: null } }\n// Matches: { age: null }    ✅ ONLY\n// Skips:   { age: 25 }     ❌\n// Skips:   { name: \"Ali\" } ❌"
                ),
            ),

            // ── Chapter 4 Module 15: Projection ───────────────────────────────
            "it_mongo_ch4_m15" to listOf(
                ContentBlock.TextBlock(
                    "🎯 MongoDB Projection\n\nAb tak find() se saare fields return hote the.\nLekin agar tumhe sirf kuch selected fields chahiye?\n\nYe kaam karta hai → Projection! 📌\n\nProjection decide karta hai:\n  Kaunse fields result mein dikhenge\n  aur kaunse nahi.\n\nYe find() ka doosra parameter hota hai."
                ),
                ContentBlock.ExampleBlock(
                    "💻 find() Method — Full Syntax",
                    "// find() ke 2 parameters:\n// Parameter 1 → Query (filter)\n// Parameter 2 → Projection (fields selection)\n\ndb.collection.find(\n  { query },      // Parameter 1: filter\n  { projection }  // Parameter 2: fields\n)\n\n// Example: query + projection\ndb.collection.find(\n  { founded_year: 2010 },  // filter\n  { name: 1, founded_year: 1 }  // projection\n)"
                ),
                ContentBlock.TextBlock(
                    "📌 Projection Syntax\n\n  field: 1 → Ye field include karo (dikhao)\n  field: 0 → Ye field exclude karo (mat dikhao)\n\n⚠️ Important Exception:\n  _id field by DEFAULT return hota hai\n  Chahe tum specify karo ya na karo.\n  Isko hatane ke liye explicitly _id: 0 likhna padta hai."
                ),
                ContentBlock.ExampleBlock(
                    "💻 Projection — Include Fields",
                    "// Sirf name aur founded_year show karo\n// (saari companies, no filter)\ndb.companies.find(\n  {},\n  {\n    name: 1,\n    founded_year: 1\n  }\n)\n\n// Result mein aayega:\n// { _id: ObjectId('...'), name: \"Google\", founded_year: 1998 }\n// Note: _id by default aata hai!"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Removing the _id Field",
                    "// _id ko bhi hatana ho to explicitly 0 likho:\ndb.companies.find(\n  {},\n  {\n    name: 1,\n    founded_year: 1,\n    _id: 0\n  }\n)\n\n// Ab result:\n// { name: \"Google\", founded_year: 1998 }\n// _id gone!"
                ),
                ContentBlock.TextBlock(
                    "🔄 Include Mode vs Exclude Mode\n\nMongoDB mein 2 modes hote hain:\n\n  Include Mode → jo fields chahiye unhe 1 do\n  Exclude Mode → jo fields nahi chahiye unhe 0 do\n\n⚠️ Rule: Dono mix NAHI kar sakte!\n  Ya to sab 1 (include) karo\n  Ya to sab 0 (exclude) karo\n\n  ✅ Exception: _id ko 0 dena allowed hai include mode mein bhi"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Include vs Exclude Mode Examples",
                    "// ✅ Include mode (sab 1):\ndb.companies.find(\n  {},\n  { name: 1, founded_year: 1 }\n)\n// → Sirf name aur founded_year dikhega\n\n// ✅ Exclude mode (sab 0):\ndb.companies.find(\n  {},\n  { overview: 0, description: 0 }\n)\n// → Baki saare fields dikhenge (in 2 ke alawa)\n\n// ✅ Valid Exception (_id ko 0 in include mode):\ndb.companies.find(\n  {},\n  { name: 1, _id: 0 }\n)\n\n// ❌ Invalid — mix nahi kar sakte:\n// { name: 1, overview: 0 }  ← ERROR!"
                ),
                ContentBlock.TextBlock(
                    "📊 Quick Reference — Projection\n\n  No projection → Saare fields return\n  field: 1     → Sirf ye field include karo\n  field: 0     → Sirf ye field exclude karo\n  _id: 0       → _id hatao (exception)\n\n  find({})     → All documents, all fields\n  find({},{name:1}) → All documents, sirf name + _id\n  find({},{name:1,_id:0}) → All documents, sirf name\n\n💡 Atlas GUI mein bhi Project option milta hai\n   Options expand karo → Project field box mein same syntax likho!"
                ),
            ),
            "it_mongo_ch4_m16" to listOf(
                ContentBlock.TextBlock(
                    "📝 Assignment Questions -2\n\nYe assignment insert aur delete operations ko cover karta hai.\nSaare questions carefully padho aur jawab do.\n\nTopics covered:\n  ✅ insert() method\n  ✅ deleteOne() aur deleteMany()\n  ✅ _id field behavior\n  ✅ Schemaless nature\n  ✅ Filter-based deletion\n  ✅ Embedded field deletion"
                ),
                ContentBlock.ExampleBlock(
                    "Q1 — insertMany with multiple documents",
                    "Question:\nnew_collection mein teen documents ek saath insert karo:\n- doc1: { item: 'pen', qty: 100 }\n- doc2: { item: 'pencil', qty: 200 }\n- doc3: { item: 'eraser', qty: 50 }\n\n─────────────────────────────────\n✅ Solution:\ndb.new_collection.insertMany([\n  { item: \"pen\",    qty: 100 },\n  { item: \"pencil\", qty: 200 },\n  { item: \"eraser\", qty: 50  }\n])\n─────────────────────────────────\n\ninsertMany() ek saath kai documents\ninsert karta hai — efficient hai!"
                ),
                ContentBlock.ExampleBlock(
                    "Q2 — deleteOne with exact match",
                    "Question:\nproducts collection se woh document delete karo\njahan item field 'pen' ho.\n\n─────────────────────────────────\n✅ Solution:\ndb.products.deleteOne({ item: \"pen\" })\n─────────────────────────────────\n\ndeleteOne() sirf pehla matching\ndocument delete karta hai."
                ),
                ContentBlock.ExampleBlock(
                    "Q3 — deleteMany with condition",
                    "Question:\nproducts collection se saare documents delete karo\njahan qty 100 se kam ho.\n\n─────────────────────────────────\n✅ Solution:\ndb.products.deleteMany({\n  qty: { \$lt: 100 }\n})\n─────────────────────────────────\n\n\$lt = less than. deleteMany() saare\nmatching documents delete karta hai."
                ),
                ContentBlock.ExampleBlock(
                    "Q4 — insertOne with nested document",
                    "Question:\norders collection mein ek document insert karo:\n- orderId: 1001\n- customer: { name: 'Rahul', city: 'Delhi' }\n- amount: 599\n\n─────────────────────────────────\n✅ Solution:\ndb.orders.insertOne({\n  orderId: 1001,\n  customer: {\n    name: \"Rahul\",\n    city: \"Delhi\"\n  },\n  amount: 599\n})\n─────────────────────────────────\n\nMongoDB mein nested objects directly\ndocument ke andar store ho sakte hain!"
                ),
            ),
            "it_mongo_ch4_m17" to listOf(
                ContentBlock.TextBlock(
                    "📥 MongoDB Insert Documents\n\nIs lecture mein hum documents ko collection mein insert karna sikhenge.\n\n🚀 Shell Se Start\nHum `sample_training` database use karenge.\n\nMongoDB mein collection implicitly create hoti hai — agar collection exist nahi karta tab bhi insert kar sakte ho.\nMongoDB automatically collection create kar deta hai.\n`createCollection()` method ki zarurat nahi!"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Insert Method Syntax",
                    "// Single document insert:\ndb.collection.insert(document)\n\n// Multiple documents insert:\ndb.collection.insert([\n  doc1,\n  doc2\n])"
                ),
                ContentBlock.TextBlock(
                    "📌 Insert Method Parameters\n\n1️⃣ First Parameter\n  ek document\n  ya documents ka array\n  Documents JSON structure follow karte hain.\n\n2️⃣ Second Parameter (optional — is lecture mein skip)\n  `writeConcern`\n  `ordered`\n  Agar omit karo to default behavior follow hoga."
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 1 — Single Document Insert",
                    "// Ek document insert karo (collection auto-create hogi)\ndb.test_collection.insert({\n  name: \"Tom Hanks\",\n  profession: \"Actor\"\n})\n\n// Result:\n// acknowledged: true"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Collection Verify Karna",
                    "// Insert ke baad check karo:\ndb.test_collection.find()\n\n// Result: Inserted document return hoga\n// Note: _id field automatically generate hoti hai!\n// Humne specify nahi kiya tha — MongoDB khud banata hai."
                ),
                ContentBlock.TextBlock(
                    "⚠️ Important Concepts\n\n✅ Same Query Dobara Run Karna\nAgar same insert query dobara run karo → ye phir bhi insert ho jayega!\nKyunki dono documents ka `_id` different hoga.\n\n✅ Same field values allowed hain\n❌ Bas `_id` unique hona chahiye\n\n⚠️ Duplicate Key Error\nAgar copied document mein same `_id` ho:\n→ Error aayega: `Duplicate Key Error`\n\n✅ MongoDB is Schemaless\nDifferent structure ke documents same collection mein insert kar sakte ho."
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Duplicate Key Error Example",
                    "// ❌ Same _id dobara insert karna → ERROR\ndb.test_collection.insert({\n  _id: ObjectId(\"abc123\"),\n  name: \"Tom Hanks\"\n})\n// Error: Duplicate Key Error"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Custom _id Field",
                    "// Apna khud ka _id specify kar sakte ho:\ndb.test_collection.insert({\n  _id: 1001,\n  name: \"Tom Hanks\",\n  profession: \"Actor\"\n})\n\n// Result: _id = 1001 wala document insert hoga\ndb.test_collection.find()\n// → Third document aa jayega jiska _id = 1001 hai"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 2 — Arrays & Embedded Documents",
                    "// Arrays aur embedded documents ke saath insert:\ndb.test_collection.insert({\n  name: \"Al Pacino\",\n  films: [\n    \"Scarface\",\n    \"The Godfather\"\n  ],\n  awards: {\n    academy: true,\n    golden_globes: true\n  }\n})\n\n// Verify:\ndb.test_collection.find()\n// → Document with array + embedded doc return hoga"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 3 — Multiple Documents Insert",
                    "// Multiple documents ek saath insert karo (array use karo):\ndb.test_collection.insert([\n  { name: \"John\" },\n  { name: \"Sarah\" },\n  { name: \"Mike\" }\n])\n\n// Verify:\ndb.test_collection.find()\n// → 3 naye documents insert ho jayenge"
                ),
                ContentBlock.TextBlock(
                    "🖥️ MongoDB Atlas Insert — Steps\n\n1️⃣ Collections pe click karo → `test_collection` open karo\n2️⃣ Insert Document button pe click karo\n3️⃣ `_id` auto generate hoti hai (unique)\n4️⃣ Field-Value pair add karo\n5️⃣ Data type specify kar sakte ho:\n   `String` / `Number` / `Boolean` / `Object` / `Array`\n\n🔹 Embedded Document add karna:\n   `Object` type select karo → phir key-value pairs\n\n🔹 Array add karna:\n   `Array` type select karo → phir elements\n\n🔹 JSON View dekhna:\n   Curly braces icon pe click karo\n\n✅ MongoDB Compass mein bhi same process hota hai."
                ),
                ContentBlock.TextBlock(
                    "🧠 Important Concepts Recap\n\n  `insert()` → Documents collection mein insert karta hai\n\n  Implicit Collection Creation\n  Agar collection exist nahi karta → MongoDB automatically create kar deta hai\n\n  `_id` field:\n    ✅ Automatically generate hoti hai\n    ✅ Unique hoti hai\n    ✅ Custom bhi de sakte ho\n\n  ⚠️ `Duplicate Key Error` → Same `_id` dobara insert karne par\n\n  ✅ Schemaless Nature → Different structure ke documents same collection mein allowed"
                ),
            ),
            "it_mongo_ch4_m18" to listOf(
                ContentBlock.TextBlock(
                    "🗑️ MongoDB Delete Documents\n\nIs lecture mein hum documents ko delete karna sikhenge.\n\nDo methods use hote hain:\n  deleteOne()\n  deleteMany()\n\nDono ka syntax almost same hota hai."
                ),
                ContentBlock.ExampleBlock(
                    "💻 Delete Methods Syntax",
                    "// Ek document delete karo:\ndb.collection.deleteOne({ filter })\n\n// Multiple documents delete karo:\ndb.collection.deleteMany({ filter })"
                ),
                ContentBlock.TextBlock(
                    "📌 Optional Parameters (Is lecture mein skip)\n  writeConcern\n  collation\n  hint\n\nAgar omit karo → Default behavior follow hota hai.\n\n✅ deleteOne()\nJo pehla document filter condition match karta hai → sirf wahi delete hota hai.\n\n✅ deleteMany()\nJo bhi documents filter condition match karte hain → sab delete ho jate hain."
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Setup — Check the Collection",
                    "// sample_training database mein hain\n// test_collection ke documents dekho:\ndb.test_collection.find()"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 1 — deleteOne()",
                    "// name = \"Tom Hanks\" wala ek document delete karo:\ndb.test_collection.deleteOne({\n  name: \"Tom Hanks\"\n})\n\n// ⚠️ Note: 'd' lowercase hai, 'O' uppercase hai\n\n// Result:\n// acknowledged: true\n// deletedCount: 1"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Verify deleteOne() Result",
                    "// Delete ke baad check karo:\ndb.test_collection.find()\n\n// Observation:\n// Pehle 3 documents the → ab 2 bache hain\n// → Sirf ek delete hua (pehla match)"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 2 — deleteMany()",
                    "// name = \"Tom Hanks\" wale SAARE documents delete karo:\ndb.test_collection.deleteMany({\n  name: \"Tom Hanks\"\n})\n\n// Verify:\ndb.test_collection.find()\n// → Ab koi bhi document nahi bacha jiska name = \"Tom Hanks\""
                ),
                ContentBlock.TextBlock(
                    "⚡ Important Difference\n\n  deleteOne()  → Sirf first match delete karta hai\n  deleteMany() → Saare matching documents delete karta hai\n\nDelete filter bilkul find() method ki tarah kaam karta hai.\nDifference sirf itna hai:\n  find()                   → Documents return karta hai\n  deleteOne()/deleteMany() → Documents delete karta hai"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 3 — Delete by Embedded Field",
                    "// Step 1: Pehle find karo (dot notation):\ndb.test_collection.find({\n  \"awards.academy\": true\n})\n\n// Step 2: find() ki jagah deleteMany() use karo:\ndb.test_collection.deleteMany({\n  \"awards.academy\": true\n})\n\n// Result: awards.academy = true wale saare documents delete\n// Example: name: \"Al Pacino\" wala document delete ho jayega"
                ),
                ContentBlock.TextBlock(
                    "🔗 Dot Notation in Delete\n\nEmbedded fields ko delete filters mein bhi use kar sakte ho:\n  \"parent.child\": value\n\nExample:\n  \"awards.academy\": true\n\n🖥️ MongoDB Atlas Delete — Steps\n1️⃣ Document locate karo → Collection open karo\n2️⃣ Trash Icon 🗑️ pe click karo\n3️⃣ Delete confirm karo → Document delete ho jayega\n\n✅ MongoDB Compass mein bhi same process — kaafi intuitive hai."
                ),
                ContentBlock.ExampleBlock(
                    "⚠️ DANGER — deleteMany({}) Safety Note",
                    "// ❌ BAHUT DANGEROUS!\n// {} matlab saare documents\ndb.users.deleteMany({})\n// → Collection ke SAARE documents delete ho jayenge!\n\n// Hamesha filter specify karo:\ndb.users.deleteMany({ status: \"inactive\" })  // ✅ Safe"
                ),
                ContentBlock.TextBlock(
                    "🧠 Important Concepts Recap\n\n  deleteOne()  → Sirf pehla matching document delete karta hai\n  deleteMany() → Saare matching documents delete karta hai\n\n  Filter Conditions → find() jaisi hi conditions use hoti hain\n  Dot Notation    → Embedded document fields access karne ke liye\n\n📚 Is lecture mein humne cover kiya:\n  ✅ deleteOne() aur deleteMany()\n  ✅ Filter-based deletion\n  ✅ Embedded field deletion (dot notation)\n  ✅ Mongo shell + Atlas delete\n  ✅ find() vs delete methods ka difference\n  ⚠️ deleteMany({}) ka danger"
                ),
            ),

            // ── Chapter 5, Module 1 — Update Documents ──────────────────────────
            "it_mongo_ch5_m1" to listOf(
                ContentBlock.TextBlock(
                    "✏️ MongoDB Update Documents\n\nIs lecture mein hum documents ko update karna sikhenge.\n\nDo main methods use hote hain:\n  `updateOne()`  → Sirf pehle matching document ko update karo\n  `updateMany()` → Saare matching documents ko update karo\n\nDono ka syntax almost same hota hai."
                ),
                ContentBlock.ExampleBlock(
                    "💻 Update Methods — Syntax",
                    "Syntax:\ndb.collection.updateOne(\n  <filter>,\n  <update>,\n  <options>    // optional\n)\n\ndb.collection.updateMany(\n  <filter>,\n  <update>,\n  <options>    // optional\n)"
                ),
                ContentBlock.TextBlock(
                    "📌 Teen Parameters Samjho\n\n`filter` — Kaunse document(s) update karne hain?\n  Same syntax jo `find()` mein use hota hai.\n  Example: { name: \"Alice\" }\n\n`update` — Kya update karna hai?\n  Update operator use hota hai — sabse common hai `\$set`\n  `\$set` → Sirf specified fields ko update karta hai, baaki intact rehte hain.\n\n`options` — Optional extra settings:\n  `upsert`      → Agar match na ho to naya document banao\n  `writeConcern`\n  `collation`\n  `arrayFilters`\n  `hint`"
                ),
                ContentBlock.ExampleBlock(
                    "🔑 \$set Operator — Kya Karta Hai?",
                    "// \$set sirf specified fields update karta hai\n// Baaki document intact rehta hai\n\n// Example: Agar document hai:\n// { _id: 1, name: \"Alice\", age: 25, city: \"Delhi\" }\n\ndb.people.updateOne(\n  { name: \"Alice\" },\n  { \$set: { age: 26 } }    // sirf age update hua\n)\n\n// Result:\n// { _id: 1, name: \"Alice\", age: 26, city: \"Delhi\" }\n// ✅ age update hua, baki fields same hain"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Setup — Check the Collection",
                    "// sample_training database mein hain\n// test_collection ke documents dekho:\ndb.test_collection.find()"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 1 — updateOne() Basic",
                    "// name = \"Alice\" wale document ki city update karo:\ndb.test_collection.updateOne(\n  { name: \"Alice\" },\n  { \$set: { city: \"Mumbai\" } }\n)\n\n// Result:\n// acknowledged: true\n// matchedCount: 1\n// modifiedCount: 1"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 2 — updateOne() Multiple Fields",
                    "// Ek hi query mein multiple fields update karo:\ndb.test_collection.updateOne(\n  { name: \"Alice\" },\n  {\n    \$set: {\n      city: \"Bangalore\",\n      age: 30,\n      status: \"active\"\n    }\n  }\n)\n\n// Result: city, age, aur status teeno update ho gaye\n// Baaki fields — jaise name, _id — same hain"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 3 — updateMany() Basic",
                    "// Saare documents jahaan city = \"Delhi\" hai,\n// unki status = \"verified\" karo:\ndb.test_collection.updateMany(\n  { city: \"Delhi\" },\n  { \$set: { status: \"verified\" } }\n)\n\n// Result:\n// matchedCount: 5   (e.g. 5 documents matched)\n// modifiedCount: 5  (sab update hue)"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 4 — Add a New Field",
                    "// Document mein pehle se koi 'score' field nahi tha\n// \$set se naya field add bhi ho jata hai:\ndb.test_collection.updateOne(\n  { name: \"Bob\" },\n  { \$set: { score: 99 } }\n)\n\n// Agar Bob ka document tha:\n// { _id: 2, name: \"Bob\", city: \"Pune\" }\n\n// Ab ho gaya:\n// { _id: 2, name: \"Bob\", city: \"Pune\", score: 99 }\n// ✅ Naya field add ho gaya"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 5 — Embedded Field Update",
                    "// awards.academy field update karo (dot notation):\ndb.test_collection.updateOne(\n  { name: \"Alice\" },\n  { \$set: { \"awards.academy\": false } }\n)\n\n// awards ek nested object hai:\n// Before: { awards: { academy: true, grammy: false } }\n// After:  { awards: { academy: false, grammy: false } }\n// ✅ Sirf awards.academy change hua, grammy intact raha"
                ),
                ContentBlock.TextBlock(
                    "⚡ Important Differences\n\n  `updateOne()`  → Sirf first match update karta hai\n  `updateMany()` → Saare matching documents update karta hai\n\n`\$set` operator:\n  → Sirf specified fields update karta hai\n  → Baaki fields intact rehte hain\n  → Naya field bhi add kar sakta hai\n\n🧠 Remember:\n  `find()`      → Documents return karta hai\n  `deleteOne()` → Documents delete karta hai\n  `updateOne()` → Documents update karta hai\n  Teeno ka filter syntax same hota hai!"
                ),
                ContentBlock.TextBlock(
                    "📚 Lecture Recap\n\n  ✅ `updateOne()` aur `updateMany()` methods\n  ✅ `\$set` operator — partial update ke liye\n  ✅ Filter parameter — find() jaisa syntax\n  ✅ Multiple fields ek saath update karna\n  ✅ Naya field add karna\n  ✅ Embedded fields update karna (dot notation)\n  ✅ matchedCount vs modifiedCount output"
                ),
            ),

            // ── Chapter 5, Module 2 — Upsert ─────────────────────────────────────
            "it_mongo_ch5_m2" to listOf(
                ContentBlock.TextBlock(
                    "🔄 Upsert kya hota hai?\n\nNormal `updateOne()` / `updateMany()` ka behavior:\n  Agar filter se koi document match kare → Update ho jaata hai\n  Agar koi match nahi mila → Kuch nahi hota (no error, no new doc)\n\n`upsert` ek special option hai jo is behavior ko change karta hai:\n  `upsert: true`  → Agar match mila → Update karo\n                    Agar match nahi mila → Naya document INSERT karo\n  `upsert: false` → Default behavior (no insert if no match)"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Upsert Syntax",
                    "Syntax:\ndb.collection.updateOne(\n  <filter>,\n  <update>,\n  { upsert: true }    // options mein upsert flag\n)\n\n// Same for updateMany:\ndb.collection.updateMany(\n  <filter>,\n  <update>,\n  { upsert: true }\n)"
                ),
                ContentBlock.TextBlock(
                    "🔍 Upsert: true vs false\n\n`upsert: false` (default):\n  → Document match hua → Update\n  → Document match nahi hua → Nothing happens\n  → matchedCount: 0, modifiedCount: 0\n\n`upsert: true`:\n  → Document match hua → Update\n  → Document match nahi hua → Naya document create hota hai\n  → matchedCount: 0, upsertedCount: 1, upsertedId: ObjectId(...)"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 1 — upsert: false (Default)",
                    "// Database mein name = \"Charlie\" wala koi document nahi hai\n\ndb.test_collection.updateOne(\n  { name: \"Charlie\" },\n  { \$set: { city: \"Chennai\" } }\n  // upsert: false by default\n)\n\n// Result:\n// acknowledged: true\n// matchedCount: 0\n// modifiedCount: 0\n// ⚠️ Kuch nahi hua — koi error nahi, koi insert nahi"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 2 — upsert: true",
                    "// Database mein name = \"Charlie\" wala koi document nahi hai\n\ndb.test_collection.updateOne(\n  { name: \"Charlie\" },\n  { \$set: { city: \"Chennai\" } },\n  { upsert: true }    // ← ye flag add karo\n)\n\n// Result:\n// acknowledged: true\n// matchedCount: 0\n// modifiedCount: 0\n// upsertedCount: 1\n// upsertedId: ObjectId(\"...\")\n\n// ✅ Naya document create hua:\n// { _id: ObjectId(\"...\"), name: \"Charlie\", city: \"Chennai\" }"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 3 — upsert: true (match mila)",
                    "// Database mein name = \"Alice\" wala document exist karta hai\n\ndb.test_collection.updateOne(\n  { name: \"Alice\" },\n  { \$set: { city: \"Hyderabad\" } },\n  { upsert: true }\n)\n\n// Result:\n// matchedCount: 1\n// modifiedCount: 1\n// (upsertedCount: 0 — koi naya doc create nahi hua)\n// ✅ Normal update hua — upsert se koi fark nahi padta jab match milta hai"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 4 — Upsert with Multiple Fields",
                    "// Naya user create karo agar exist nahi karta:\ndb.users.updateOne(\n  { email: \"newuser@example.com\" },\n  {\n    \$set: {\n      name: \"New User\",\n      city: \"Kolkata\",\n      status: \"active\"\n    }\n  },\n  { upsert: true }\n)\n\n// Agar email match nahi mila:\n// → Naya document banayega with email + name + city + status\n// filter ki email field bhi naye doc mein include hogi!"
                ),
                ContentBlock.TextBlock(
                    "💡 Upsert ka Use Case\n\nUpsert tab useful hota hai jab:\n  → Tumhe confirm nahi ki document pehle se exist karta hai ya nahi\n  → Exist karta hai to update karo\n  → Exist nahi karta to create karo\n\nReal-world examples:\n  → User profile save karna (create or update)\n  → Settings store karna\n  → Cache-like behavior\n\n⚠️ Dhyan raho:\n  `upsert: true` galti se use karne pe unwanted documents ban sakte hain!\n  Filter dhyan se likho."
                ),
                ContentBlock.TextBlock(
                    "📚 Lecture Recap\n\n  ✅ `upsert` option ka concept\n  ✅ `upsert: false` → Default, no insert on miss\n  ✅ `upsert: true`  → Insert if no match found\n  ✅ `upsertedId` response field\n  ✅ Match mila to: normal update hota hai\n  ✅ Match nahi mila + upsert: true → Naya document create\n  ✅ Filter fields bhi naye document mein include hoti hain"
                ),
            ),

            // ── Chapter 5, Module 3 — Atlas UI Update ────────────────────────────
            "it_mongo_ch5_m3" to listOf(
                ContentBlock.TextBlock(
                    "🖥️ MongoDB Atlas UI se Documents Update Karna\n\nShell commands ke alawa, MongoDB Atlas ka Data Explorer bhi use kar sakte ho documents update karne ke liye.\n\nAtlas UI update — 2 tarike:\n  1️⃣  Pencil icon ✏️ → In-place edit\n  2️⃣  JSON editor → Full document edit"
                ),
                ContentBlock.ExampleBlock(
                    "✏️ Step 1 — Open Document Edit Mode",
                    "Atlas Data Explorer mein:\n\n1️⃣  apna database aur collection open karo\n    e.g. sample_training → test_collection\n\n2️⃣  Jis document ko update karna hai uske\n    paas pencil icon (✏️) pe click karo\n\n3️⃣  Document edit mode mein khul jayega\n    → Har field editable ban jaati hai\n    → Value pe click karo → type karo"
                ),
                ContentBlock.ExampleBlock(
                    "✏️ Step 2 — Change a Field Value",
                    "Edit mode mein:\n\n→ Field value pe click karo\n→ Nayi value type karo\n→ Update/Save button dabao\n\nExample:\n  name: \"Alice\"  →  name: \"Alicia\"\n  age: 25        →  age: 26\n  city: \"Delhi\"  →  city: \"Mumbai\"\n\n✅ Changes save hone ke baad collection\n   automatically refresh hoti hai"
                ),
                ContentBlock.ExampleBlock(
                    "🔧 Step 3 — Change the Data Type",
                    "Atlas UI mein data type bhi change kar sakte ho:\n\n1️⃣  Edit mode mein field ki value ke paas\n    data type dropdown dikhega\n    (e.g. String, Int32, Double, Boolean, etc.)\n\n2️⃣  Dropdown se nayi type select karo\n\nExample:\n  age: \"25\" (String)  →  age: 25 (Int32)\n  active: 1 (Int32)   →  active: true (Boolean)\n\n✅ Type mismatch se query issues avoid hote hain"
                ),
                ContentBlock.ExampleBlock(
                    "➕ Step 4 — Add a New Field",
                    "Document mein naya field add karne ke liye:\n\n1️⃣  Edit mode mein sabse neeche\n    '+ Add Field' button dikhega\n\n2️⃣  Field name type karo\n\n3️⃣  Data type select karo\n\n4️⃣  Value enter karo\n\n5️⃣  Save karo\n\nExample naya field:\n  score: 95 (Int32)\n  verified: true (Boolean)"
                ),
                ContentBlock.ExampleBlock(
                    "📋 Step 5 — Edit an Array Field",
                    "Array type field ko edit karna:\n\n1️⃣  Array field pe click karo\n    → Array expand ho jaayegi\n    → Har element alag dikhega\n\n2️⃣  Existing element edit karo\n    → Element pe click karo → nayi value type karo\n\n3️⃣  Naya element add karo\n    → Array ke andar '+ Add Item' pe click karo\n\n4️⃣  Element delete karo\n    → Element ke paas trash icon 🗑️ pe click karo\n\n✅ Arrays visually expand hoti hain — easy to manage"
                ),
                ContentBlock.TextBlock(
                    "🔄 Atlas UI vs Shell — Comparison\n\nAtlas UI (Data Explorer):\n  ✅ Visual, point-and-click interface\n  ✅ Data type dropdown available\n  ✅ Beginners ke liye easy\n  ✅ Single document edit ke liye fast\n  ❌ Bulk updates ke liye inefficient\n  ❌ Complex operators (\$set, \$inc) directly nahi dikhte\n\nMongo Shell (`updateOne`/`updateMany`):\n  ✅ Bulk updates ke liye perfect\n  ✅ Complex operators available\n  ✅ Automation aur scripting ke liye\n  ✅ Production environments ke liye\n  ❌ Command line knowledge zaroori\n  ❌ Visual feedback nahi"
                ),
                ContentBlock.TextBlock(
                    "📚 Lecture Recap\n\n  ✅ Atlas Data Explorer se documents update karna\n  ✅ Pencil icon se edit mode open karna\n  ✅ Field values change karna\n  ✅ Data types change karna (String → Int32, etc.)\n  ✅ Naya field add karna\n  ✅ Array elements edit karna\n  ✅ Atlas UI vs Shell ka comparison\n\n💡 Best Practice:\n  → Ek-do documents ke liye → Atlas UI use karo\n  → Bulk updates ke liye → Shell use karo"
                ),
            ),
            // ── Chapter 6 — Aggregation Framework ────────────────────────────────

            // ── Ch6 M1: Intro to Aggregation ─────────────────────────────────────
            "it_mongo_ch6_m1" to listOf(
                ContentBlock.TextBlock(
                    "Aggregation Pipeline kya hai?\n\nEk problem socho! Tumhare paas 10,000 students ke grades hain. Tumhe chahiye: 'Sirf un students ki list jo maths mein 90+ laaye, aur unhe city ke hisaab se group karo, aur har city ka average nikalo.'\n\nYe sirf find() se nahi hoga! Iske liye chahiye \u2014 Aggregation Pipeline!\n\nMQL (find, insert, update) simple ek-step kaam ke liye hai. Aggregation Pipeline tab use hoti hai jab multiple steps chahiye \u2014 pehle filter, phir group, phir calculate, phir sort. Bilkul ek assembly line ki tarah!"
                ),
                ContentBlock.TextBlock(
                    "\uD83C\uDFED Aggregation Pipeline kya hai?\n\nPipeline = ek sequence of operations (stages)\n\nHar stage apna kaam karta hai aur:\n  \u2192 Input leta hai (documents)\n  \u2192 Processing karta hai\n  \u2192 Output deta hai (processed documents)\n  \u2192 Ye output next stage ka input ban jaata hai\n\nYaani: pehle stage ka output \u2192 doosre stage ka input \u2192 aage"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83C\uDFED Assembly Line Analogy",
                    "Iron ore \u2192 Melt \u2192 Shape \u2192 Paint \u2192 Car ready!\n\nAggregate Pipeline (sample_training.companies):\n  Input:          saare companies documents\n  Stage 1 (\$match):   sirf 2005\u20132010 wale\n  Stage 2 (\$project): sirf category_code aur founded_year\n  Stage 3 (\$group):   category_code ke hisaab se group karo\n  Output:         har category mein companies ka count"
                ),
                ContentBlock.TextBlock(
                    "\uD83D\uDD11 Common Aggregation Stages\n\n  \$match   \u2192 Documents filter karo (find() jaisa)\n  \$project \u2192 Fields select/transform karo\n  \$group   \u2192 Data group karo aur aggregate karo\n\nAur bhi hain:\n  \$sort    \u2192 Sort karo\n  \$limit   \u2192 N documents tak limit karo\n  \$skip    \u2192 N documents skip karo\n  \$unwind  \u2192 Array ko alag documents mein tod do\n  \$lookup  \u2192 Doosre collection se join karo"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDCBB aggregate() \u2014 Syntax",
                    "Syntax:\ndb.collection.aggregate([\n  { \$match: { <filter> } },\n  { \$project: { <fields> } },\n  { \$group: { <grouping> } }\n])"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Full 3-Stage Example",
                    "// companies: filter 2005\u20132010, project fields, group by category\ndb.companies.aggregate([\n  {\n    \$match: {\n      founded_year: { \$gte: 2005, \$lte: 2010 }\n    }\n  },\n  {\n    \$project: {\n      _id: 0,\n      category_code: 1,\n      founded_year: 1\n    }\n  },\n  {\n    \$group: {\n      _id: \"\$category_code\",\n      count: { \$sum: 1 }\n    }\n  }\n])"
                ),
                ContentBlock.TextBlock(
                    "\\uD83D\\uDCDA Lecture Recap\n\n  \u2705 MQL vs Aggregation Framework ka difference\n  \u2705 Pipeline = stages ka sequence\n  \u2705 Har stage ka output \u2192 next stage ka input\n  \u2705 Assembly line analogy\n  \u2705 Common stages: \$match, \$project, \$group\n  \u2705 aggregate() syntax\n\n\uD83D\uDCA1 Yaad rakho: Aggregation Framework powerful hai kyunki tum ek query mein filter, transform, aur aggregate \u2014 teeno kaam kar sakte ho!"
                ),
            ),

            // ── Ch6 M2: $match Stage ──────────────────────────────────────────────
            "it_mongo_ch6_m2" to listOf(
                ContentBlock.TextBlock(
                    "\uD83D\uDD0D \$match Stage kya hai?\n\nAggregate pipeline mein \$match stage:\n  \u2192 find() ki tarah documents filter karta hai\n  \u2192 Sirf matching documents aage pass hote hain\n  \u2192 Non-matching documents pipeline mein nahi jaate\n\nBest Practice:\n  \u2192 \$match ko pipeline mein sabse pehle rakho\n  \u2192 Isse kum documents next stages mein jaate hain\n  \u2192 Performance improve hoti hai"
                ),
                ContentBlock.TextBlock(
                    "\uD83D\uDD00 \$match vs find()\n\nfind():\n  \u2192 Result return karta hai\n  \u2192 Filter + projection dono ek command mein\n  \u2192 Sirf collection par use hota hai\n\n\$match:\n  \u2192 Pipeline mein use hota hai\n  \u2192 Sirf filter karta hai (projection nahi)\n  \u2192 Multiple stages ke saath chain ho sakta hai\n  \u2192 Ek pipeline mein multiple \$match stages allowed hain\n\nDono support karte hain: \$gt, \$lt, \$gte, \$lte, \$and, \$or, \$elemMatch, etc."
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example 1 \u2014 Range Filter",
                    "// founded_year 2005 se 2010 ke beech filter karo\ndb.companies.aggregate([\n  {\n    \$match: {\n      founded_year: { \$gte: 2005, \$lte: 2010 }\n    }\n  }\n])"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example 1 \u2014 Explicit \$and",
                    "// Same query, explicit \$and ke saath\ndb.companies.aggregate([\n  {\n    \$match: {\n      \$and: [\n        { founded_year: { \$gte: 2005 } },\n        { founded_year: { \$lte: 2010 } }\n      ]\n    }\n  }\n])"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example 2 \u2014 Simple Equality",
                    "// class_id: 116 waale documents\ndb.grades.aggregate([\n  {\n    \$match: { class_id: 116 }\n  }\n])\n\n// Sirf class_id: 116 waale documents aage jaate hain"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example 3 \u2014 \$elemMatch in Array",
                    "// scores array mein type=\"exam\" AND score > 85\ndb.grades.aggregate([\n  {\n    \$match: {\n      scores: {\n        \$elemMatch: {\n          type: \"exam\",\n          score: { \$gt: 85 }\n        }\n      }\n    }\n  }\n])\n\n// Sirf wahi documents jahan scores array mein\n// koi element ho jiska type=\"exam\" AND score > 85"
                ),
                ContentBlock.TextBlock(
                    "\\uD83D\\uDCDA Lecture Recap\n\n  \u2705 \$match = pipeline filter stage\n  \u2705 Best practice: pipeline mein sabse pehle use karo\n  \u2705 Sab MQL operators support karta hai\n  \u2705 Ek pipeline mein multiple \$match stages allowed\n  \u2705 \$match vs find(): \$match mein projection nahi hoti\n  \u2705 \$elemMatch: array elements par conditions\n\n\uD83D\uDCA1 Yaad rakho: \$match jitna pehle rakho, utna efficient pipeline banega!"
                ),
            ),

            // ── Ch6 M3: $project Stage ───────────────────────────────────────────
            "it_mongo_ch6_m3" to listOf(
                ContentBlock.TextBlock(
                    "\uD83C\uDFAF \$project Stage kya hai?\n\nAggregate pipeline mein \$project stage:\n  \u2192 Documents ke fields select/transform karta hai\n  \u2192 1 = include, 0 = exclude\n  \u2192 find() projection se zyada powerful hai\n\n_id ka behavior:\n  \u2192 _id default se return hota hai\n  \u2192 Hide karne ke liye: _id: 0 likhna padta hai\n\nShell mein 20 documents ek baar mein dikhte hain\n  \u2192 Aur dekhne ke liye: `it` type karo"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDCBB Basic Include/Exclude",
                    "// name aur founded_year include, _id hide\ndb.companies.aggregate([\n  {\n    \$project: {\n      _id: 0,\n      name: 1,\n      founded_year: 1\n    }\n  }\n])\n\n// _id: 0 \u2192 hide\n// name: 1 \u2192 show\n// founded_year: 1 \u2192 show"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDD17 Dot Notation \u2014 Embedded Fields",
                    "// Embedded document ka field include karna\ndb.companies.aggregate([\n  {\n    \$project: {\n      _id: 0,\n      name: 1,\n      \"offices.city\": 1\n    }\n  }\n])\n\n// Dot notation se nested field access karo"
                ),
                ContentBlock.ExampleBlock(
                    "\u270F\uFE0F Field Rename \u2014 Field Reference",
                    "// \"\$fieldName\" = field ki value ko reference karta hai\ndb.companies.aggregate([\n  {\n    \$project: {\n      _id: 0,\n      company_name: \"\$name\",\n      employees: \"\$number_of_employees\"\n    }\n  }\n])\n\n// company_name = name field ki value\n// employees = number_of_employees field ki value"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDD22 Calculated Field \u2014 \$divide",
                    "// tripduration (seconds) ko minutes mein convert\ndb.trips.aggregate([\n  {\n    \$project: {\n      _id: 0,\n      tripduration: 1,\n      duration_minutes: {\n        \$divide: [\"\$tripduration\", 60]\n      }\n    }\n  }\n])\n\n// duration_minutes = tripduration / 60\n// Original document modify NAHI hota"
                ),
                ContentBlock.TextBlock(
                    "\u2696\uFE0F \$project vs find() Projection\n\nfind() projection:\n  \u2192 Sirf include/exclude kar sakta hai\n  \u2192 New fields create nahi kar sakta\n  \u2192 Basic aur limited\n\n\$project (aggregation):\n  \u2192 Include/exclude\n  \u2192 New fields create kar sakta hai\n  \u2192 Field rename kar sakta hai\n  \u2192 Mathematical calculations kar sakta hai\n  \u2192 Field references use kar sakta hai (\"\$fieldName\")\n  \u2192 Underlying document permanently modify NAHI karta"
                ),
                ContentBlock.TextBlock(
                    "\\uD83D\\uDCDA Lecture Recap\n\n  \u2705 \$project: fields select aur transform karo\n  \u2705 1 = include, 0 = exclude\n  \u2705 _id: 0 se _id hide karo\n  \u2705 Dot notation se embedded fields access karo\n  \u2705 \"\$fieldName\" = field reference\n  \u2705 Calculated fields banana\n  \u2705 Fields rename karna\n  \u2705 \$project vs find() projection ka fark\n\n\uD83D\uDCA1 Yaad rakho: \$project powerful hai \u2014 sirf dikhata hai, original data change NAHI karta!"
                ),
            ),

            // ── Ch6 M4: Assignment Questions ─────────────────────────────────────
            "it_mongo_ch6_m4" to listOf(
                ContentBlock.TextBlock(
                    "\uD83D\uDCDD Practice: \$match + \$project\n\nIn assignments mein hum seekhi hui cheezein practice karenge:\n  \u2192 \$match se filter karna\n  \u2192 \$project se fields select karna\n  \u2192 ISODate() se dates compare karna\n  \u2192 Implicit AND (multiple conditions)\n  \u2192 Case sensitivity\n\nData collections:\n  \u2192 sample_training.trips\n  \u2192 sample_training.zips"
                ),
                ContentBlock.ExampleBlock(
                    "\u2705 Q1 \u2014 trips: stop_time se filter karo",
                    "// stop_time > 2016-01-05 wale documents\ndb.trips.aggregate([\n  {\n    \$match: {\n      stop_time: {\n        \$gt: ISODate(\"2016-01-05\")\n      }\n    }\n  }\n])\n\n// ISODate format: YYYY-MM-DD\n// Time nahi likha to default: 00:00:00"
                ),
                ContentBlock.TextBlock(
                    "\uD83D\uDCC5 ISODate() ke baare mein\n\n\u2192 MongoDB dates ke liye ISODate() use karta hai\n\u2192 Format: YYYY-MM-DD\n\u2192 Time agar nahi likha: 00:00:00 default hota hai\n\u2192 Comparison operators dates ke saath bhi kaam karte hain\n  (\$gt, \$gte, \$lt, \$lte)\n\u2192 Numbers aur strings ki tarah dates bhi compare kar sakte ho"
                ),
                ContentBlock.ExampleBlock(
                    "\u2705 Q2 \u2014 trips: coordinates project karo",
                    "// start_station_location.coordinates field project karo\ndb.trips.aggregate([\n  {\n    \$project: {\n      _id: 0,\n      start_station_location: \"\$start_station_location.coordinates\"\n    }\n  }\n])\n\n// Embedded field ko field reference se access kiya"
                ),
                ContentBlock.ExampleBlock(
                    "\u2705 Q3 \u2014 zips: Houston filter + project",
                    "// zips mein city=\"HOUSTON\" + pop > 40000\n// filter karo, phir zip aur pop project karo\ndb.zips.aggregate([\n  {\n    \$match: {\n      city: \"HOUSTON\",\n      pop: { \$gt: 40000 }\n    }\n  },\n  {\n    \$project: {\n      _id: 0,\n      zip: \"\$_id\",\n      pop: 1\n    }\n  }\n])\n\n// Implicit AND: dono conditions ek object mein\n// Case sensitive: \"HOUSTON\" nahi to \"houston\""
                ),
                ContentBlock.TextBlock(
                    "\uD83D\uDCDA Key Concepts Recap\n\n  \u2705 \$gt date comparison: ISODate() ke saath\n  \u2705 ISODate format: YYYY-MM-DD\n  \u2705 Time nahi diya to 00:00:00 default\n  \u2705 Field reference: \"\$fieldName.nested\"\n  \u2705 Implicit AND: ek object mein multiple conditions\n  \u2705 Case sensitive: 'HOUSTON' \u2260 'houston'\n  \u2705 \$match aur \$project saath mein powerful pipeline\n\n\uD83D\uDCA1 \$match pehle rakho \u2192 sirf relevant documents \$project tak pahunche!"
                ),
            ),

            // ── Ch6 M5: Arithmetic Operators ─────────────────────────────────────
            "it_mongo_ch6_m5" to listOf(
                ContentBlock.TextBlock(
                    "\uD83D\uDD22 Arithmetic Expression Operators\n\nMongoDB aggregation mein mathematical operations ke liye:\n\n  \$add      \u2192 Numbers ya dates ka sum (multiple values)\n  \$subtract \u2192 Exactly 2 values ka fark (dates bhi)\n  \$divide   \u2192 Exactly 2 values divide\n  \$multiply \u2192 Multiple values multiply\n  \$round    \u2192 Number round karo [number, decimalPlaces]\n\nAur bhi operators:\n  \$abs   \u2192 Absolute value\n  \$log   \u2192 Logarithm\n  \$sqrt  \u2192 Square root\n  \$ceil  \u2192 Ceiling (upar wala integer)\n  \$floor \u2192 Floor (neeche wala integer)"
                ),
                ContentBlock.ExampleBlock(
                    "\u00F7 \$divide \u2014 Example",
                    "// tripduration (seconds) ko minutes mein convert\ndb.trips.aggregate([\n  {\n    \$project: {\n      _id: 0,\n      tripduration: 1,\n      duration_minutes: {\n        \$divide: [\"\$tripduration\", 60]\n      }\n    }\n  }\n])\n\n// \$divide: [dividend, divisor]\n// Sirf 2 values allowed"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDD01 \$round \u2014 Example",
                    "// Result ko 1 decimal place tak round karo\ndb.trips.aggregate([\n  {\n    \$project: {\n      _id: 0,\n      duration_minutes_rounded: {\n        \$round: [\n          { \$divide: [\"\$tripduration\", 60] },\n          1\n        ]\n      }\n    }\n  }\n])\n\n// \$round: [number, decimalPlaces]\n// Nested operators allowed hain!"
                ),
                ContentBlock.ExampleBlock(
                    "\u274C Wrong: Expression in \$match (no \$expr)",
                    "// ❌ WRONG: expression operator directly \$match mein\n// Koi error nahi, lekin koi result bhi nahi!\ndb.trips.aggregate([\n  {\n    \$match: {\n      tripduration: {\n        \$gt: { \$multiply: [\"\$tripduration\", 3] }\n      }\n    }\n  }\n])\n\n// Problem: \$match mein expression operators\n// \$expr ke bina directly kaam nahi karte"
                ),
                ContentBlock.ExampleBlock(
                    "\u2705 Correct: \$expr ke saath \$match",
                    "// ✅ CORRECT: \$expr ke andar expression operators\ndb.trips.aggregate([\n  {\n    \$match: {\n      \$expr: {\n        \$gt: [\n          { \$multiply: [\"\$tripduration\", 3] },\n          \"\$birth_year\"\n        ]\n      }\n    }\n  }\n])\n\n// \$expr: expression operators ko \$match mein\n// allow karta hai\n// \$gt: [expr1, expr2] — field se field compare"
                ),
                ContentBlock.TextBlock(
                    "\u2696\uFE0F \$project vs \$match: Expression Operators\n\n\$project mein:\n  \u2192 Expression operators directly use karo\n  \u2192 \$expr ki zaroorat NAHI\n  \u2192 Example: { \$divide: [\"\$tripduration\", 60] }\n\n\$match mein:\n  \u2192 Expression operators directly KAAM NAHI KARTE\n  \u2192 \$expr wrapper zaroori hai\n  \u2192 Bina \$expr ke: query chalti hai, error nahi, lekin koi result nahi\n  \u2192 Example: { \$expr: { \$gt: [...] } }"
                ),
                ContentBlock.TextBlock(
                    "\\uD83D\\uDCDA Lecture Recap\n\n  \u2705 Arithmetic operators: \$add, \$subtract, \$divide, \$multiply, \$round\n  \u2705 \$round: [number, decimalPlaces]\n  \u2705 Nested operators allowed (e.g. \$round mein \$divide)\n  \u2705 \$match mein expression operators = \$expr zaroori\n  \u2705 \$project mein expression operators = direct use\n  \u2705 Bina \$expr ke \$match: no error, no result\n  \u2705 Field references: \"\$fieldName\" (string mein dollar)\n\n\uD83D\uDCA1 Rule: \$project mein expression direct, \$match mein \$expr ke andar!"
                ),
            ),
            // ── Ch6 M6: String Operators ─────────────────────────────────────────
            "it_mongo_ch6_m6" to listOf(
                ContentBlock.TextBlock(
                    "\uD83D\uDD25 String Expression Operators\n\nMongoDB aggregation mein strings ke saath kaam karne ke liye:\n\n  \$concat      \u2192 Multiple strings ko join karta hai\n  \$toUpper    \u2192 String ko uppercase mein convert karta hai\n  \$toLower    \u2192 String ko lowercase mein convert karta hai\n  \$regexMatch \u2192 Pattern search karta hai (true/false return)\n\nAur bhi operators:\n  \$dateFromString \u2192 String ko date object mein convert karo\n  \$ltrim          \u2192 Left whitespace remove karo\n  \$trim           \u2192 Leading/trailing whitespace remove karo\n  \$split          \u2192 Delimiter ke basis pe string split karo"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDCBB \$concat \u2014 Syntax",
                    "Syntax:\n{ \$concat: [expression1, expression2, expression3] }\n\n// Multiple expressions use kar sakte ho\n// Dynamic field references + static strings dono mix kar sakte ho"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDCBB \$toUpper / \$toLower \u2014 Syntax",
                    "// Uppercase conversion\n{ \$toUpper: expression }\n\n// Lowercase conversion\n{ \$toLower: expression }\n\n// Sirf ek expression leta hai (array nahi)"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDCBB \$regexMatch \u2014 Syntax",
                    "Syntax:\n{\n  \$regexMatch: {\n    input: expression,   // kaunsi string evaluate karni hai\n    regex: pattern,     // kaunsa pattern search karna hai\n    options: options    // optional behavior\n  }\n}\n\n// options examples:\n//   case sensitivity, whitespace ignore, multiline matching"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example 1 \u2014 \$toUpper",
                    "// start station name ko uppercase mein display karo\ndb.trips.aggregate([\n  {\n    \$project: {\n      start_station_name_upper: {\n        \$toUpper: \"\$start station name\"\n      }\n    }\n  }\n])\n\n// Result: Howard Ave \u2192 HOWARD AVE"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example 2 \u2014 \$regexMatch (Boolean Flag)",
                    "// Howard_flag: kya station name 'Howard' se start hota hai?\ndb.trips.aggregate([\n  {\n    \$project: {\n      start_station_name: 1,\n      Howard_flag: {\n        \$regexMatch: {\n          input: \"\$start station name\",\n          regex: \"Howard\"\n        }\n      }\n    }\n  }\n])\n\n// Howard milega \u2192 Howard_flag: true\n// Howard nahi milega \u2192 Howard_flag: false"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example 3 \u2014 \$concat (journey Field)",
                    "// journey: start station - end station format\ndb.trips.aggregate([\n  {\n    \$project: {\n      start_station_name: 1,\n      journey: {\n        \$concat: [\n          \"\$start station name\",\n          \" - \",\n          \"\$end station name\"\n        ]\n      }\n    }\n  }\n])\n\n// \" - \" ek static separator string hai\n// Result: Howard Ave - Central Park"
                ),
                ContentBlock.TextBlock(
                    "\uD83E\uDDE0 Operator Comparison\n\n  \$toUpper    \u2192 Uppercase conversion\n  \$toLower    \u2192 Lowercase conversion\n  \$concat     \u2192 Strings join karna\n  \$regexMatch \u2192 Pattern matching (true/false)\n\n\ud83d\udcda Lecture Recap\n\n  \u2705 \$concat: multiple strings join, static + dynamic mix\n  \u2705 \$toUpper / \$toLower: case conversion, ek single expression\n  \u2705 \$regexMatch: pattern search, returns boolean true/false\n  \u2705 \$regexMatch params: input, regex, options (optional)\n  \u2705 Boolean flag fields create kar sakte ho\n  \u2705 Documentation mein har operator ke examples available hain\n\n\uD83D\uDCA1 Yaad rakho: \$concat dynamic + static strings combine kar sakta hai!"
                ),
            ),

            // ── Ch6 M7: Date Operators ────────────────────────────────────────────
            "it_mongo_ch6_m7" to listOf(
                ContentBlock.TextBlock(
                    "\uD83D\uDCC5 Date Expression Operators\n\nMongoDB aggregation mein dates ke saath kaam karne ke liye:\n\n  \$dateAdd   \u2192 Date mein time units add karo (days/hours/months/years)\n  \$dateDiff  \u2192 Do dates ke beech difference return karo\n  \$month     \u2192 Date ka month number return karo\n\nAur bhi operators:\n  \$dateToString \u2192 Date ko formatted string mein convert karo\n  \$dayOfMonth  \u2192 Month ka day number return karo\n  \$dayOfWeek   \u2192 Week ka day return karo\n  \$dayOfYear   \u2192 Year ka day number return karo"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDCBB \$dateAdd \u2014 Syntax",
                    "Syntax:\n{\n  \$dateAdd: {\n    startDate: date,      // required\n    unit: unit,           // required: day/hour/month/year\n    amount: amount,       // required: kitna add karna hai\n    timezone: timezone    // optional\n  }\n}\n\n// Example: 1 day add, 5 hours add, 2 months add kar sakte ho"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDCBB \$dateDiff \u2014 Syntax",
                    "Syntax:\n{\n  \$dateDiff: {\n    startDate: date1,     // required\n    endDate: date2,       // required\n    unit: unit,           // required: day/hour/month/year\n    timezone: timezone,   // optional\n    startOfWeek: value    // optional\n  }\n}\n\n// Do dates ke beech difference calculate karta hai"
                ),
                ContentBlock.TextBlock(
                    "\uD83D\uDD22 \$month \u2014 Month Number Extract Karo\n\n\$month date ka month NUMBER return karta hai:\n\n  January   \u2192 1\n  February  \u2192 2\n  March     \u2192 3\n  ...\n  December  \u2192 12\n\nSyntax: { \$month: expression }\nExample: { \$month: \"\$start_time\" }"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example \u2014 Extract Month Number",
                    "// sample_training.trips: start_time ka month number nikalo\ndb.trips.aggregate([\n  {\n    \$project: {\n      start_time: 1,\n      month_no: {\n        \$month: \"\$start_time\"\n      }\n    }\n  }\n])\n\n// start_time = January \u2192 month_no = 1\n// start_time = December \u2192 month_no = 12"
                ),
                ContentBlock.TextBlock(
                    "\uD83C\uDF0D Real-World Uses\n\nDate operators use hote hain:\n  \u2192 Reporting aur analytics\n  \u2192 Monthly summaries\n  \u2192 Time calculations\n  \u2192 Dashboards aur trends analysis\n\n\ud83d\udcda Lecture Recap\n\n  \u2705 \$dateAdd: date mein time units add karo\n  \u2705 \$dateAdd required: startDate, unit, amount (timezone optional)\n  \u2705 \$dateDiff: do dates ka difference (startDate, endDate, unit required)\n  \u2705 \$month: month number extract karo (Jan=1, Dec=12)\n  \u2705 Aur bhi: \$dateToString, \$dayOfMonth, \$dayOfWeek, \$dayOfYear\n  \u2705 \"\$fieldName\" syntax se field values access karo\n\n\uD83D\uDCA1 Date operators real-world reporting mein frequently use hote hain!"
                ),
            ),

            // ── Ch6 M8: Comparison Expression Operators ───────────────────────────
            "it_mongo_ch6_m8" to listOf(
                ContentBlock.TextBlock(
                    "\uD83D\uDD25 Comparison Expression Operators\n\nComparison operators pehle MQL module mein cover ho chuke hain.\nYahan sirf aggregation context mein unka syntax discuss karenge.\n\nComparison operators:\n  \$gt  \u2192 Greater than\n  \$gte \u2192 Greater than or equal\n  \$lt  \u2192 Less than\n  \$lte \u2192 Less than or equal\n  \$eq  \u2192 Equal\n  \$ne  \u2192 Not equal"
                ),
                ContentBlock.TextBlock(
                    "\u26A0\uFE0F Important: MQL vs Expression Syntax\n\nMQL Query Syntax (find/match):\n  { field: { \$gt: value } }\n  \u2192 Normal filtering syntax\n\nExpression Operator Syntax (aggregation):\n  { \$gt: [expression1, expression2] }\n  \u2192 Array-based syntax use hota hai\n\nRule:\n  \$match mein expression syntax \u2192 \$expr mandatory\n  \$project mein \u2192 expression syntax directly allowed\n  \$project mein MQL syntax \u2192 ERROR aayega"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example 1 \u2014 MQL Style in \$match",
                    "// MQL query syntax: query operator ki tarah\ndb.trips.aggregate([\n  {\n    \$match: {\n      tripduration: {\n        \$gt: 100      // query syntax\n      }\n    }\n  }\n])\n\n// Ye QUERY syntax hai, expression syntax nahi"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example 2 \u2014 Expression Style with \$expr",
                    "// Expression syntax: \$match mein \$expr ke saath zaroori\ndb.trips.aggregate([\n  {\n    \$match: {\n      \$expr: {\n        \$gt: [\"\$tripduration\", 100]\n      }\n    }\n  }\n])\n\n// \$expr: expression evaluation allow karta hai\n// \"\$tripduration\": field value reference"
                ),
                ContentBlock.ExampleBlock(
                    "\uD83D\uDE80 Example 3 \u2014 Boolean Flag in \$project",
                    "// \$project mein expression operators directly (no \$expr)\ndb.trips.aggregate([\n  {\n    \$project: {\n      tripduration: 1,\n      over_100_flag: {\n        \$gt: [\"\$tripduration\", 100]\n      }\n    }\n  }\n])\n\n// tripduration > 100 \u2192 over_100_flag = true\n// tripduration \u2264 100 \u2192 over_100_flag = false"
                ),
                ContentBlock.TextBlock(
                    "\u274C Wrong Syntax in \$project\n\n// MQL query syntax \$project mein ERROR dega!\n// WRONG:\n\$project: { tripduration: { \$gt: 100 } }\n\n// \$project SIRF expression syntax accept karta hai:\n// CORRECT:\n\$project: { over_100_flag: { \$gt: [\"\$tripduration\", 100] } }"
                ),
                ContentBlock.TextBlock(
                    "\\uD83D\\uDCDA Lecture Recap\n\n  \u2705 Comparison operators: \$gt, \$gte, \$lt, \$lte, \$eq, \$ne\n  \u2705 MQL syntax: { field: { \$gt: value } }\n  \u2705 Expression syntax: { \$gt: [expr1, expr2] } \u2014 array-based\n  \u2705 \$match mein expression syntax \u2192 \$expr required\n  \u2705 \$project mein expression syntax \u2192 directly (no \$expr)\n  \u2705 \$project mein query syntax \u2192 ERROR\n  \u2705 \$project mein comparison \u2192 true/false boolean flag\n\n\uD83D\uDCA1 Key: \$project sirf expression syntax; \$match dono (with/without \$expr)!"
                ),
            ),
            "it_mongo_ch6_m9" to listOf(
                ContentBlock.TextBlock(
                    "🔥 Array Expression Operators\n\nArray operators aggregation pipeline mein arrays ke saath kaam karne dete hain.\n\nMukhya operators:\n  \$isArray   → Check karo agar value array hai\n  \$size      → Array ke elements ki count\n  \$arrayElemAt → Specific index par element\n  \$first     → Pehla element\n  \$last      → Aakhri element\n  \$concatArrays → Arrays ko merge karo\n  \$map       → Har element par expression apply karo"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — \$isArray and \$size",
                    "db.collection.aggregate([\n  {\n    \$project: {\n      field: 1,\n      isFieldArray: { \$isArray: \"\$field\" },\n      arraySize: {\n        \$cond: [\n          { \$isArray: \"\$field\" },\n          { \$size: \"\$field\" },\n          0\n        ]\n      }\n    }\n  }\n])\n\n// \$isArray: true/false return karta hai\n// \$size sirf array par kaam karta hai, isliye pehle check karo"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 2 — \$arrayElemAt, \$first, \$last",
                    "db.orders.aggregate([\n  {\n    \$project: {\n      items: 1,\n      firstItem:  { \$first: \"\$items\" },\n      lastItem:   { \$last:  \"\$items\" },\n      secondItem: { \$arrayElemAt: [\"\$items\", 1] }\n    }\n  }\n])\n\n// \$first / \$last: shorthand for index 0 / -1\n// \$arrayElemAt: [array, index] — 0-based; negative counts from end"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 3 — \$concatArrays",
                    "db.inventory.aggregate([\n  {\n    \$project: {\n      allItems: {\n        \$concatArrays: [\"\$inStock\", \"\$ordered\"]\n      }\n    }\n  }\n])\n\n// \$concatArrays: array of arrays leta hai\n// Dono arrays ko ek array mein combine karta hai"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 4 — \$map",
                    "db.products.aggregate([\n  {\n    \$project: {\n      discountedPrices: {\n        \$map: {\n          input: \"\$prices\",\n          as: \"price\",\n          in: { \$multiply: [\"\$\$price\", 0.9] }\n        }\n      }\n    }\n  }\n])\n\n// input: source array\n// as: variable naam (access karo \$\$ se)\n// in: har element par apply hone wala expression\n// \$\$price = current element ka reference"
                ),
                ContentBlock.TextBlock(
                    "📚 Summary\n\n  ✅ \$isArray: true/false — array check\n  ✅ \$size: array length (sirf arrays par)\n  ✅ \$arrayElemAt: [array, index] — 0-based\n  ✅ \$first / \$last: pehla / aakhri element\n  ✅ \$concatArrays: multiple arrays ko merge karo\n  ✅ \$map: { input, as, in } — \$\$ se variable access\n\n💡 Tip: \$size use karne se pehle \$isArray se check karo!"
                ),
            ),
            "it_mongo_ch6_m10" to listOf(
                ContentBlock.TextBlock(
                    "🔥 Conditional Expression Operators\n\nConditional operators value ko condition ke basis par decide karte hain.\n\nTeen mukhya operators:\n  \$cond   → if-then-else\n  \$ifNull → null/missing field ko replace karo\n  \$switch → multiple cases (like switch statement)"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — \$cond (Array Syntax)",
                    "db.orders.aggregate([\n  {\n    \$project: {\n      item: 1,\n      discount: {\n        \$cond: [\n          { \$gte: [\"\$qty\", 250] },\n          30,\n          20\n        ]\n      }\n    }\n  }\n])\n\n// Array syntax: [ <condition>, <ifTrue>, <ifFalse> ]\n// qty >= 250 → discount = 30\n// qty < 250  → discount = 20"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 2 — \$cond (Object Syntax)",
                    "db.orders.aggregate([\n  {\n    \$project: {\n      item: 1,\n      discount: {\n        \$cond: {\n          if:   { \$gte: [\"\$qty\", 250] },\n          then: 30,\n          else: 20\n        }\n      }\n    }\n  }\n])\n\n// Object syntax: { if, then, else }\n// Dono syntaxes equivalent hain — object syntax zyada readable"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 3 — \$ifNull",
                    "db.employees.aggregate([\n  {\n    \$project: {\n      name: 1,\n      department: {\n        \$ifNull: [\"\$department\", \"Not Assigned\"]\n      }\n    }\n  }\n])\n\n// \$ifNull: [expression, replacementValue]\n// Agar \$department null ya missing hai\n//   → \"Not Assigned\" return karo\n// Warna \$department ki actual value"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 4 — \$switch",
                    "db.grades.aggregate([\n  {\n    \$project: {\n      name: 1,\n      grade: {\n        \$switch: {\n          branches: [\n            { case: { \$gte: [\"\$score\", 90] }, then: \"A\" },\n            { case: { \$gte: [\"\$score\", 75] }, then: \"B\" },\n            { case: { \$gte: [\"\$score\", 60] }, then: \"C\" }\n          ],\n          default: \"F\"\n        }\n      }\n    }\n  }\n])\n\n// branches: array of { case, then } objects\n// default: koi branch match na ho tab\n// Top-to-bottom evaluate hota hai"
                ),
                ContentBlock.TextBlock(
                    "📚 Summary\n\n  ✅ \$cond: [ condition, ifTrue, ifFalse ] — ya object { if, then, else }\n  ✅ \$ifNull: [ expression, replacement ] — null/missing handle karo\n  ✅ \$switch: { branches: [{case,then}...], default } — multiple cases\n\n💡 Tip: \$switch mein branches top-to-bottom match hoti hain — specific conditions pehle rakho!"
                ),
            ),
            "it_mongo_ch6_m11" to listOf(
                ContentBlock.TextBlock(
                    "📝 Assignment: Arrays & Conditional Operators\n\nIn questions mein array aur conditional expression operators ka practice hoga.\n\nTopics covered:\n  • \$isArray, \$size, \$arrayElemAt\n  • \$first, \$last, \$concatArrays, \$map\n  • \$cond, \$ifNull, \$switch\n  • Inhe \$project ke saath combine karna"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Practice Problem 1",
                    "// students collection mein har student ke liye:\n// - subjects array ka size nikalo\n// - pehla subject nikalo\n// - agar marks null hai to 0 dikhao\n\ndb.students.aggregate([\n  {\n    \$project: {\n      name: 1,\n      subjectCount: { \$size: \"\$subjects\" },\n      firstSubject: { \$first: \"\$subjects\" },\n      marks: { \$ifNull: [\"\$marks\", 0] }\n    }\n  }\n])"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Practice Problem 2",
                    "// orders collection mein:\n// - totalItems = items1 aur items2 arrays ko merge karo\n// - discount: qty >= 100 → 15%, warna 5%\n\ndb.orders.aggregate([\n  {\n    \$project: {\n      totalItems: {\n        \$concatArrays: [\"\$items1\", \"\$items2\"]\n      },\n      discountPct: {\n        \$cond: [\n          { \$gte: [\"\$qty\", 100] },\n          15,\n          5\n        ]\n      }\n    }\n  }\n])"
                ),
                ContentBlock.TextBlock(
                    "📚 Key Points\n\n  ✅ \$size use karne se pehle ensure karo ki field array hai\n  ✅ \$concatArrays input mein sirf arrays hone chahiye\n  ✅ \$cond aur \$switch \$project ke andar directly use ho sakte hain\n  ✅ \$ifNull null aur missing dono ke liye kaam karta hai\n  ✅ \$map ke andar variable \$\$ prefix se access hota hai"
                ),
            ),
            "it_mongo_ch6_m12" to listOf(
                ContentBlock.TextBlock(
                    "🔥 \$addFields Stage\n\n\$addFields ek aggregation stage hai jo documents mein nayi fields add karta hai.\n\nKey Points:\n  • Existing fields ko preserve karta hai (unlike \$project)\n  • Sirf nayi fields define karo — baaki sab automatically aate hain\n  • \$project se zyada convenient jab sirf add karna ho\n\nSyntax:\n  { \$addFields: { newField: <expression> } }"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — Basic \$addFields",
                    "db.scores.aggregate([\n  {\n    \$addFields: {\n      totalScore: {\n        \$add: [\"\$midterm\", \"\$final\"]\n      },\n      grade: \"Pending\"\n    }\n  }\n])\n\n// Document mein totalScore aur grade add ho jayenge\n// midterm, final, aur baaki sab fields bhi rahenge\n// \$project use karte to sirf listed fields aate"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 2 — \$addFields vs \$project",
                    "// \$project — sirf listed fields:\ndb.col.aggregate([\n  { \$project: { name: 1, total: { \$add: [\"\$a\", \"\$b\"] } } }\n])\n// Result: { name, total }  ← _id + listed fields only\n\n// \$addFields — existing + nayi:\ndb.col.aggregate([\n  { \$addFields: { total: { \$add: [\"\$a\", \"\$b\"] } } }\n])\n// Result: { _id, a, b, ..., total }  ← sab fields + total"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 3 — Adding a Nested Field",
                    "db.employees.aggregate([\n  {\n    \$addFields: {\n      \"contact.fullAddress\": {\n        \$concat: [\n          \"\$contact.street\", \", \", \"\$contact.city\"\n        ]\n      }\n    }\n  }\n])\n\n// Dot notation se nested field add ho sakti hai\n// Existing contact object preserve rehta hai"
                ),
                ContentBlock.TextBlock(
                    "📚 Summary\n\n  ✅ \$addFields: existing documents mein nayi fields add karo\n  ✅ Existing fields preserve rehti hain (unlike \$project)\n  ✅ Syntax: { \$addFields: { field: expression } }\n  ✅ Dot notation se nested fields bhi add ho sakti hain\n\n💡 Rule: Agar sirf fields add karni hain → \$addFields; agar fields include/exclude karne hain → \$project!"
                ),
            ),
            "it_mongo_ch6_m13" to listOf(
                ContentBlock.TextBlock(
                    "🔥 \$sort, \$count, \$limit, \$skip\n\nYe cursor-like stages pipeline mein documents ko order, count, aur filter karte hain.\n\n\$sort  → Documents ko sort karo\n\$count → Documents count karo aur field mein store karo\n\$limit → Pehle N documents lo\n\$skip  → Pehle N documents skip karo"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — \$sort",
                    "db.students.aggregate([\n  { \$sort: { score: -1, name: 1 } }\n])\n\n// score: -1 → descending (highest first)\n// name: 1   → ascending (A to Z)\n// Multiple fields: pehli field primary sort,\n//   second field tie-breaker\n// \$sort pipeline mein kahin bhi use ho sakta hai"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 2 — \$count",
                    "db.orders.aggregate([\n  { \$match: { status: \"completed\" } },\n  { \$count: \"completedOrders\" }\n])\n// Result: { completedOrders: 42 }\n\n// \$count ek string leta hai — woh field name hai\n// Sirf ek document return karta hai with the count\n// Pipeline mein is point tak ke documents count hote hain"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 3 — \$limit and \$skip",
                    "// Top 5 highest scores:\ndb.students.aggregate([\n  { \$sort:  { score: -1 } },\n  { \$limit: 5 }\n])\n\n// Pagination — page 3, 10 per page:\ndb.products.aggregate([\n  { \$sort:  { _id: 1 } },\n  { \$skip:  20 },   // page 3 start (skip 2 pages)\n  { \$limit: 10 }   // 10 results\n])\n\n// \$skip pehle, phir \$limit for pagination"
                ),
                ContentBlock.TextBlock(
                    "📚 Summary\n\n  ✅ \$sort: { field: 1 } ascending, { field: -1 } descending\n  ✅ \$count: \"fieldName\" — count single document mein store karta hai\n  ✅ \$limit: N — pehle N documents\n  ✅ \$skip: N — pehle N documents skip karo\n\n💡 Pagination pattern: \$sort → \$skip → \$limit (is order mein!)"
                ),
            ),
            "it_mongo_ch6_m14" to listOf(
                ContentBlock.TextBlock(
                    "📝 Assignment: \$addFields and Sorting\n\nIs assignment mein \$addFields, \$sort, \$limit, \$skip ka practice karenge.\n\nTopics:\n  • Nayi computed fields add karna\n  • Results sort karna\n  • Pagination implement karna\n  • \$addFields ko doosre stages ke saath combine karna"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Practice Problem 1",
                    "// employees collection:\n// 1. annualSalary field add karo (salary * 12)\n// 2. annualSalary ke basis par descending sort karo\n// 3. Top 3 employees return karo\n\ndb.employees.aggregate([\n  {\n    \$addFields: {\n      annualSalary: { \$multiply: [\"\$salary\", 12] }\n    }\n  },\n  { \$sort: { annualSalary: -1 } },\n  { \$limit: 3 }\n])"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Practice Problem 2",
                    "// products collection:\n// 1. Active products filter karo\n// 2. discountedPrice = price * 0.85 add karo\n// 3. Price ascending sort karo\n// 4. Page 2 dikhao (5 items per page)\n\ndb.products.aggregate([\n  { \$match: { active: true } },\n  {\n    \$addFields: {\n      discountedPrice: { \$multiply: [\"\$price\", 0.85] }\n    }\n  },\n  { \$sort: { price: 1 } },\n  { \$skip: 5 },\n  { \$limit: 5 }\n])"
                ),
                ContentBlock.TextBlock(
                    "📚 Key Takeaways\n\n  ✅ \$addFields pipeline ke kisi bhi point par use ho sakta hai\n  ✅ Computed field add karke usse baad sort ya filter kar sakte hain\n  ✅ Pagination: \$sort → \$skip → \$limit order maintain karo\n  ✅ \$skip value = (pageNumber - 1) * pageSize\n\n💡 Performance: \$match ko pehle rakho taaki processed documents kam ho!"
                ),
            ),
            "it_mongo_ch6_m15" to listOf(
                ContentBlock.TextBlock(
                    "🔥 \$group Stage\n\n\$group documents ko group karke aggregation perform karta hai.\n\nSyntax:\n  { \$group: { _id: <expression>, field: { <accumulator>: <expr> } } }\n\n_id: kis field par group karna hai (null = sab documents ek group)\n\nAccumulator operators:\n  \$sum   → Total sum\n  \$avg   → Average\n  \$max   → Maximum value\n  \$min   → Minimum value\n  \$first → Group ka pehla document\n  \$last  → Group ka aakhri document\n  \$push  → Array mein values collect karo\n  \$addToSet → Unique values ka array"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — Basic Grouping",
                    "db.orders.aggregate([\n  {\n    \$group: {\n      _id: \"\$status\",\n      totalOrders: { \$sum: 1 },\n      totalRevenue: { \$sum: \"\$amount\" },\n      avgAmount: { \$avg: \"\$amount\" }\n    }\n  }\n])\n\n// status ke basis par group karo\n// \$sum: 1 = count (har doc ke liye 1 add karo)\n// \$sum: \"\$amount\" = amount field ka total"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 2 — Multiple Field Grouping",
                    "db.sales.aggregate([\n  {\n    \$group: {\n      _id: {\n        year: { \$year: \"\$date\" },\n        category: \"\$category\"\n      },\n      total: { \$sum: \"\$amount\" },\n      maxSale: { \$max: \"\$amount\" }\n    }\n  },\n  { \$sort: { \"_id.year\": 1 } }\n])\n\n// _id mein object → multiple fields par group\n// Sort ke liye \"_id.year\" dot notation"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 3 — \$push and \$addToSet",
                    "db.orders.aggregate([\n  {\n    \$group: {\n      _id: \"\$customerId\",\n      allItems:    { \$push: \"\$item\" },\n      uniqueItems: { \$addToSet: \"\$item\" }\n    }\n  }\n])\n\n// \$push: sab values (duplicates included)\n// \$addToSet: sirf unique values\n// Dono array return karte hain"
                ),
                ContentBlock.TextBlock(
                    "📚 Summary\n\n  ✅ _id: grouping expression (\"\$field\" ya null ya object)\n  ✅ \$sum: 1 = count; \$sum: \"\$field\" = total\n  ✅ \$avg, \$max, \$min: statistical aggregations\n  ✅ \$push: sab values array mein; \$addToSet: unique values\n  ✅ _id: null → sab documents ek group mein\n\n💡 Rule: \$group ke baad existing document structure gone — sirf _id aur accumulator fields rahti hain!"
                ),
            ),
            "it_mongo_ch6_m16" to listOf(
                ContentBlock.TextBlock(
                    "🔥 \$bucket and \$bucketAuto\n\n\$bucket: Documents ko user-defined ranges (buckets) mein categorize karo\n\$bucketAuto: MongoDB khud equal-sized buckets banata hai\n\n\$bucket Syntax:\n  {\n    \$bucket: {\n      groupBy: <expression>,\n      boundaries: [b0, b1, b2, ...],\n      default: \"Other\",\n      output: { field: { accumulator } }\n    }\n  }\n\nboundaries: ascending order mein; N boundaries = N-1 buckets\ndefault: boundary ke bahar values ke liye"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — \$bucket",
                    "db.artists.aggregate([\n  {\n    \$bucket: {\n      groupBy: \"\$age\",\n      boundaries: [0, 25, 40, 55, 100],\n      default: \"Unknown\",\n      output: {\n        count: { \$sum: 1 },\n        names: { \$push: \"\$name\" }\n      }\n    }\n  }\n])\n\n// Buckets: [0,25), [25,40), [40,55), [55,100)\n// age < 0 ya >= 100 → \"Unknown\" bucket\n// _id = lower boundary of each bucket"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 2 — \$bucketAuto",
                    "db.products.aggregate([\n  {\n    \$bucketAuto: {\n      groupBy: \"\$price\",\n      buckets: 4,\n      output: {\n        count: { \$sum: 1 },\n        avgPrice: { \$avg: \"\$price\" }\n      }\n    }\n  }\n])\n\n// MongoDB automatically 4 equal buckets banata hai\n// Har bucket mein approximately equal documents\n// _id = { min, max } boundaries\n// granularity option: POWERSOF2, R5, R10, etc."
                ),
                ContentBlock.TextBlock(
                    "📚 Comparison\n\n\$bucket:\n  ✅ Manual boundaries define karo\n  ✅ Exact control chahiye tab\n  ✅ default bucket boundary ke bahar values ke liye\n\n\$bucketAuto:\n  ✅ MongoDB boundaries calculate karta hai\n  ✅ Equal distribution chahiye tab\n  ✅ granularity: standard numeric series use karo\n\n💡 Use \$bucket when domain matters (age groups, price tiers); use \$bucketAuto for exploratory analysis!"
                ),
            ),
            "it_mongo_ch6_m17" to listOf(
                ContentBlock.TextBlock(
                    "🔥 \$facet Stage\n\n\$facet ek single stage mein multiple independent aggregation pipelines run karta hai.\n\nUse Case: Ek hi data par multiple perspectives chahiye — jaise ecommerce search results mein:\n  • Products list\n  • Category counts\n  • Price ranges\n  • Rating distribution\n\nSyntax:\n  {\n    \$facet: {\n      facet1: [ <pipeline stages> ],\n      facet2: [ <pipeline stages> ],\n      ...\n    }\n  }"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — Basic \$facet",
                    "db.artwork.aggregate([\n  {\n    \$facet: {\n      priceBuckets: [\n        {\n          \$bucket: {\n            groupBy: \"\$price\",\n            boundaries: [0, 200, 400],\n            default: \"Other\"\n          }\n        }\n      ],\n      categoryCounts: [\n        { \$group: { _id: \"\$category\", count: { \$sum: 1 } } },\n        { \$sort: { count: -1 } }\n      ],\n      totalArtworks: [\n        { \$count: \"total\" }\n      ]\n    }\n  }\n])"
                ),
                ContentBlock.TextBlock(
                    "💡 Key Points\n\n  ✅ \$facet sirf ek document return karta hai\n  ✅ Us document mein har facet ek field hai (array value)\n  ✅ Har facet independently process hoti hai\n  ✅ \$facet ke andar \$facet use nahi kar sakte\n  ✅ \$facet ke andar \$out use nahi kar sakte\n  ✅ Input documents sabhi facets ko milte hain\n\nResult format:\n  {\n    priceBuckets: [...],\n    categoryCounts: [...],\n    totalArtworks: [...]\n  }"
                ),
            ),
            "it_mongo_ch6_m18" to listOf(
                ContentBlock.TextBlock(
                    "🔥 \$sortByCount Stage\n\n\$sortByCount ek shorthand stage hai jo \$group + \$sort ko combine karta hai.\n\nYe equivalent hai:\n  { \$group: { _id: <expression>, count: { \$sum: 1 } } },\n  { \$sort: { count: -1 } }\n\nSyntax:\n  { \$sortByCount: <expression> }\n\nResult:\n  { _id: <group_value>, count: <number> }\n  — descending order by count"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — Basic \$sortByCount",
                    "// Category ke basis par count karo, most common pehle\ndb.products.aggregate([\n  { \$sortByCount: \"\$category\" }\n])\n\n// Equivalent to:\ndb.products.aggregate([\n  { \$group: { _id: \"\$category\", count: { \$sum: 1 } } },\n  { \$sort: { count: -1 } }\n])\n\n// Result: [{ _id: \"Electronics\", count: 150 }, ...]"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 2 — \$sortByCount with \$unwind",
                    "// Tags array mein har tag ki frequency count karo\ndb.articles.aggregate([\n  { \$unwind: \"\$tags\" },\n  { \$sortByCount: \"\$tags\" }\n])\n\n// \$unwind: array ko individual documents mein tod do\n// \$sortByCount: har tag ka count nikaalo\n// Most used tags pehle aayenge"
                ),
                ContentBlock.TextBlock(
                    "📚 Summary\n\n  ✅ \$sortByCount: { \$group + \$sort } shorthand\n  ✅ Expression pe group karta hai, count field add karta hai\n  ✅ Descending order by count (most common pehle)\n  ✅ Simple frequency analysis ke liye perfect\n  ✅ Aksar \$unwind ke baad use hota hai arrays ke liye\n\n💡 Jab bhi \"frequency of X\" chahiye, \$sortByCount pehle try karo!"
                ),
            ),
            "it_mongo_ch6_m19" to listOf(
                ContentBlock.TextBlock(
                    "📝 Assignment: \$group, \$sort and \$bucket\n\nIs assignment mein grouping, sorting, aur bucketing ka practice karenge.\n\nTopics:\n  • \$group ke saath accumulators\n  • \$bucket manual ranges ke saath\n  • \$bucketAuto automatic distribution\n  • Stages ko combine karna"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Practice Problem 1",
                    "// sales collection:\n// Region ke basis par group karo\n// Har region ke liye: total sales, avg sale, max sale\n// Total descending sort karo\n\ndb.sales.aggregate([\n  {\n    \$group: {\n      _id: \"\$region\",\n      totalSales: { \$sum: \"\$amount\" },\n      avgSale:    { \$avg: \"\$amount\" },\n      maxSale:    { \$max: \"\$amount\" }\n    }\n  },\n  { \$sort: { totalSales: -1 } }\n])"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Practice Problem 2",
                    "// employees collection:\n// Salary ko 4 buckets mein divide karo:\n//   [0,30000), [30000,60000), [60000,90000), [90000,)\n// Har bucket mein count aur average nikalo\n\ndb.employees.aggregate([\n  {\n    \$bucket: {\n      groupBy: \"\$salary\",\n      boundaries: [0, 30000, 60000, 90000],\n      default: \"90000+\",\n      output: {\n        count: { \$sum: 1 },\n        avgSalary: { \$avg: \"\$salary\" }\n      }\n    }\n  }\n])"
                ),
                ContentBlock.TextBlock(
                    "📚 Key Takeaways\n\n  ✅ \$group _id = grouping field; null = single group for all\n  ✅ \$sum: 1 counts documents; \$sum: \"\$field\" sums values\n  ✅ \$bucket boundaries ascending; N+1 values = N buckets\n  ✅ default = boundary ke bahar documents ke liye bucket\n  ✅ \$bucketAuto = equal distribution automatically\n\n💡 \$match pehle lagao taaki \$group kam data process kare!"
                ),
            ),
            "it_mongo_ch6_m20" to listOf(
                ContentBlock.TextBlock(
                    "🔥 \$unwind Stage\n\n\$unwind array field ko deconstruct karta hai — har array element ke liye ek alag document banata hai.\n\nSyntax:\n  { \$unwind: \"\$arrayField\" }\n  — ya —\n  {\n    \$unwind: {\n      path: \"\$arrayField\",\n      includeArrayIndex: \"fieldName\",\n      preserveNullAndEmptyArrays: true\n    }\n  }"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — Basic \$unwind",
                    "// inventory collection:\n// { item: \"ABC\", sizes: [\"S\", \"M\", \"L\"] }\n\ndb.inventory.aggregate([\n  { \$unwind: \"\$sizes\" }\n])\n\n// Result:\n// { item: \"ABC\", sizes: \"S\" }\n// { item: \"ABC\", sizes: \"M\" }\n// { item: \"ABC\", sizes: \"L\" }\n\n// Ek document teen documents ban gaya!\n// Baaki fields duplicate ho jaati hain"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 2 — Advanced Options",
                    "db.orders.aggregate([\n  {\n    \$unwind: {\n      path: \"\$items\",\n      includeArrayIndex: \"itemIndex\",\n      preserveNullAndEmptyArrays: true\n    }\n  }\n])\n\n// includeArrayIndex: \"itemIndex\"\n//   → Array position (0, 1, 2...) ek field mein\n// preserveNullAndEmptyArrays: true\n//   → null array ya empty array wale docs bhi include\n//   → Warna ye documents pipeline se nikal jaate"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 3 — \$unwind + \$group",
                    "// Articles collection mein tags array hai\n// Har tag ki frequency nikalo\n\ndb.articles.aggregate([\n  { \$unwind: \"\$tags\" },\n  {\n    \$group: {\n      _id: \"\$tags\",\n      articleCount: { \$sum: 1 }\n    }\n  },\n  { \$sort: { articleCount: -1 } }\n])\n\n// \$unwind → har tag alag document mein\n// \$group → same tags group ho jaate hain"
                ),
                ContentBlock.TextBlock(
                    "📚 Summary\n\n  ✅ \$unwind: array → individual documents (one per element)\n  ✅ Non-array fields duplicate ho jaati hain\n  ✅ includeArrayIndex: position track karne ke liye\n  ✅ preserveNullAndEmptyArrays: null/empty arrays preserve\n  ✅ Aksar \$group ke pehle use hota hai array analysis ke liye\n\n💡 Warning: \$unwind documents ki count badha deta hai — performance pe dhyan do!"
                ),
            ),
            "it_mongo_ch6_m21" to listOf(
                ContentBlock.TextBlock(
                    "🔥 \$out Stage\n\n\$out aggregation pipeline ke results ko ek collection mein write karta hai.\n\nKey Points:\n  • Pipeline ka LAST stage hona chahiye\n  • Agar collection exist karta hai → replace ho jaata hai\n  • Agar collection exist nahi karta → nayi banata hai\n  • Aggregation ke beech bhi save kar sakte ho\n\nSyntax:\n  { \$out: \"collectionName\" }\n  — ya —\n  { \$out: { db: \"otherDB\", coll: \"collName\" } }"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — Basic \$out",
                    "db.orders.aggregate([\n  { \$match: { status: \"completed\" } },\n  {\n    \$group: {\n      _id: \"\$customerId\",\n      totalSpent: { \$sum: \"\$amount\" }\n    }\n  },\n  { \$out: \"customerTotals\" }\n])\n\n// Pipeline results \"customerTotals\" collection mein save\n// Agar customerTotals exist karta tha → replace ho gaya\n// Regular collection ki tarah query kar sakte ho"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 2 — Different Database",
                    "db.sourceCollection.aggregate([\n  { \$match: { active: true } },\n  { \$project: { name: 1, email: 1 } },\n  {\n    \$out: {\n      db: \"reportingDB\",\n      coll: \"activeUsers\"\n    }\n  }\n])\n\n// Alag database mein save kar sakte ho\n// db naam specify karo\n// Useful for ETL workflows aur reporting databases"
                ),
                ContentBlock.TextBlock(
                    "📚 Key Rules\n\n  ✅ Pipeline ka last stage — kuch aur baad mein nahi\n  ✅ Existing collection → atomic replacement\n  ✅ Nayi collection create ho sakti hai automatically\n  ✅ \$facet ke andar use nahi kar sakte\n  ✅ { db, coll } syntax se cross-database output\n\n💡 Warning: \$out poori collection replace karta hai — iska dhyan rakho! Incremental updates ke liye \$merge stage (MongoDB 4.2+) consider karo."
                ),
            ),
            "it_mongo_ch6_m22" to listOf(
                ContentBlock.TextBlock(
                    "🔥 Combining Pipeline Stages\n\nAggregation pipeline ki asli power tab aati hai jab stages ko combine karo.\n\nBest Practices:\n  1. \$match pehle rakho — documents early filter karo\n  2. \$project jaldi karo — unnecessary fields drop karo\n  3. \$sort se pehle \$limit karo jab possible ho\n  4. Indexed fields par \$match karo for performance\n  5. Pipeline stages ka order matter karta hai!"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 1 — Complete ETL Pipeline",
                    "db.rawSales.aggregate([\n  // Step 1: Relevant data filter karo\n  { \$match: { year: 2024, active: true } },\n\n  // Step 2: Computed fields add karo\n  {\n    \$addFields: {\n      revenue: { \$multiply: [\"\$qty\", \"\$price\"] },\n      month: { \$month: \"\$date\" }\n    }\n  },\n\n  // Step 3: Region aur month par group karo\n  {\n    \$group: {\n      _id: { region: \"\$region\", month: \"\$month\" },\n      totalRevenue: { \$sum: \"\$revenue\" },\n      orderCount:   { \$sum: 1 }\n    }\n  },\n\n  // Step 4: Sort karo\n  { \$sort: { \"_id.month\": 1, totalRevenue: -1 } },\n\n  // Step 5: Output collection mein save karo\n  { \$out: \"monthlySalesReport\" }\n])"
                ),
                ContentBlock.ExampleBlock(
                    "🚀 Example 2 — Multi-Facet Analysis",
                    "db.products.aggregate([\n  // Sirf active products\n  { \$match: { active: true } },\n\n  // Array field unwind karo\n  { \$unwind: \"\$tags\" },\n\n  // Multiple analyses ek saath\n  {\n    \$facet: {\n      tagFrequency: [\n        { \$sortByCount: \"\$tags\" },\n        { \$limit: 10 }\n      ],\n      priceBuckets: [\n        {\n          \$bucket: {\n            groupBy: \"\$price\",\n            boundaries: [0, 100, 500, 1000],\n            default: \"1000+\"\n          }\n        }\n      ],\n      total: [ { \$count: \"count\" } ]\n    }\n  }\n])"
                ),
                ContentBlock.TextBlock(
                    "📚 All Stages Summary\n\n  ✅ \$match    → filter (pehle lagao!)\n  ✅ \$project  → fields include/exclude/compute\n  ✅ \$addFields → fields add (existing preserve)\n  ✅ \$group   → group + accumulate\n  ✅ \$sort    → order documents\n  ✅ \$limit   → N documents tak\n  ✅ \$skip    → N documents skip\n  ✅ \$count   → count field create karo\n  ✅ \$unwind  → array → individual docs\n  ✅ \$bucket  → manual ranges\n  ✅ \$bucketAuto → auto ranges\n  ✅ \$facet   → multiple parallel pipelines\n  ✅ \$sortByCount → group + sort shorthand\n  ✅ \$out    → collection mein write (last stage)\n\n💡 Pipeline = assembly line: har stage pehle waale ka output le kaam karta hai!"
                ),
            ),
        ) }

        private val questions: Map<String, List<Question>> by lazy { mapOf(
            "it_mongo_ch4_m5" to listOf(
                Question(
                    id = "ch4mq5_1",
                    questionText = "inspections collection ka ek document return karne ke liye kaunsa command sahi hai?",
                    options = listOf(
                        Option("a", "db.inspections.find()"),
                        Option("b", "db.inspections.FindOne()"),
                        Option("c", "db.inspections.findOne()"),
                        Option("d", "DB.inspections.findone()")
                    ),
                    correctOptionId = "c",
                    explanation = "db.inspections.findOne() sahi hai — 'db' aur 'find' lowercase mein, aur 'One' mein uppercase O. Baaki options case sensitivity galat hone ki wajah se kaam nahi karenge."
                ),
                Question(
                    id = "ch4mq5_2",
                    questionText = "Shell mein do conditions se filter karne ka sahi syntax kaunsa hai?",
                    options = listOf(
                        Option("a", "db.col.find({result: 'A'} AND {sector: 'B'})"),
                        Option("b", "db.col.find({\"result\": \"A\", \"sector\": \"B\"})"),
                        Option("c", "db.col.find({result: A, sector: B})"),
                        Option("d", "db.col.findMany({\"result\": \"A\"}, {\"sector\": \"B\"})")
                    ),
                    correctOptionId = "b",
                    explanation = "Multiple conditions ko ek hi curly braces mein comma se alag karke likhte hain. Fields aur string values double quotes mein hote hain. AND keyword ya alag curly braces use nahi karte."
                ),
                Question(
                    id = "ch4mq5_3",
                    questionText = "Atlas Data Explorer mein filter karte waqt kaunsa syntax use hota hai?",
                    options = listOf(
                        Option("a", "SQL SELECT syntax"),
                        Option("b", "Wahi JSON syntax jo shell mein use hota hai"),
                        Option("c", "BSON format"),
                        Option("d", "XML format")
                    ),
                    correctOptionId = "b",
                    explanation = "Atlas Data Explorer ka filter box wahi JSON syntax accept karta hai jo shell mein find() method mein use hota hai — jaise { \"sector\": \"Fuel Oil Dealer - 814\" }. GUI alag hai lekin query language same hai."
                ),
            ),
            "it_mongo_ch4_m4" to listOf(
                Question(
                    id = "ch4mq4_1",
                    questionText = "Shell mein collection create karne ka sahi syntax kaunsa hai?",
                    options = listOf(
                        Option("a", "db.CreateCollection('test_col')"),
                        Option("b", "db.createcollection('test_col')"),
                        Option("c", "db.createCollection('test_col')"),
                        Option("d", "db.create('test_col')")
                    ),
                    correctOptionId = "c",
                    explanation = "db.createCollection('test_col') sahi hai — 'create' mein lowercase c aur 'Collection' mein uppercase C. Case sensitivity galat hone par 'is not a function' error aata hai."
                ),
                Question(
                    id = "ch4mq4_2",
                    questionText = "Shell mein 'use nonexistent_db' type karne par kya hoga?",
                    options = listOf(
                        Option("a", "Error aayega — database exist nahi karta"),
                        Option("b", "Database automatically create ho jaayega turant"),
                        Option("c", "Switched to DB message aayega, database tab banega jab collection/data daalo"),
                        Option("d", "Atlas par naya cluster create ho jaayega")
                    ),
                    correctOptionId = "c",
                    explanation = "MongoDB mein 'use' command error nahi deta — sirf switched message aata hai. Database actually tab create hota hai jab usmein koi collection ya data insert ho. Ise implicit creation kehte hain."
                ),
                Question(
                    id = "ch4mq4_3",
                    questionText = "Shell mein collection drop karne ke baad 'true' aane ka kya matlab hai?",
                    options = listOf(
                        Option("a", "Collection already delete thi"),
                        Option("b", "Operation successful raha — collection drop ho gayi"),
                        Option("c", "Collection backup le liya gaya"),
                        Option("d", "Compass mein refresh karna padega")
                    ),
                    correctOptionId = "b",
                    explanation = "db.collection.drop() 'true' return karta hai jab collection successfully drop ho jaati hai. 'false' aane ka matlab hai operation successful nahi hua."
                ),
            ),
            "it_mongo_ch4_m3" to listOf(
                Question(
                    id = "ch4mq3_1",
                    questionText = "Inme se kaunsa command kaam karega trips collection ka document fetch karne ke liye?",
                    options = listOf(
                        Option("a", "Db.trips.findOne()"),
                        Option("b", "db.Trips.findOne()"),
                        Option("c", "db.trips.FindOne()"),
                        Option("d", "db.trips.findOne()")
                    ),
                    correctOptionId = "d",
                    explanation = "db.trips.findOne() sahi hai — db lowercase, trips lowercase (collection naam exactly as saved), findOne mein find lowercase aur One uppercase O. Baaki teeno options case sensitivity galat hone ki wajah se fail ho jaayenge."
                ),
                Question(
                    id = "ch4mq3_2",
                    questionText = "Query mein non-numerical values (jaise strings) kaise likhni chahiye?",
                    options = listOf(
                        Option("a", "Bina quotes ke — { result: Violation Issued }"),
                        Option("b", "Double quotes mein — { \"result\": \"Violation Issued\" }"),
                        Option("c", "Square brackets mein — [ result: Violation Issued ]"),
                        Option("d", "Asterisk se — { result: *Violation Issued* }")
                    ),
                    correctOptionId = "b",
                    explanation = "Non-numerical values ko double quotes mein likhna good practice hai. Numbers ko quotes ki zarurat nahi, lekin strings hamesha quotes mein honi chahiye — warna MongoDB parse nahi kar paata."
                ),
                Question(
                    id = "ch4mq3_3",
                    questionText = "Agar tum admin database mein ho aur db.grades.findOne() run karo to kya hoga?",
                    options = listOf(
                        Option("a", "grades collection ka pehla document milega"),
                        Option("b", "Kaam nahi karega — grades collection sample_training mein hai, admin mein nahi"),
                        Option("c", "Automatically sample_training switch ho jaayega"),
                        Option("d", "Error aayega aur MongoDB crash ho jaayega")
                    ),
                    correctOptionId = "b",
                    explanation = "Context bahut zaroori hai! grades collection sample_training database mein hai. Agar tum admin mein ho to ye query kaam nahi karegi. Pehle 'use sample_training' karo phir query chalao."
                ),
            ),
            "it_mongo_ch4_m2" to listOf(
                Question(
                    id = "ch4mq2_1",
                    questionText = "Atlas Data Explorer mein filter box mein kya type karte hain?",
                    options = listOf(
                        Option("a", "SQL WHERE clause"),
                        Option("b", "Curly braces mein key-value pair — { \"field\": value }"),
                        Option("c", "Collection ka naam"),
                        Option("d", "Python dictionary syntax")
                    ),
                    correctOptionId = "b",
                    explanation = "Atlas Data Explorer ke filter box mein wahi JSON syntax use hota hai jo shell mein hota hai — curly braces mein key-value pairs. Jaise { \"class_id\": 419 } type karke Apply karo."
                ),
                Question(
                    id = "ch4mq2_2",
                    questionText = "Data Explorer mein 'Options' button se kya milta hai?",
                    options = listOf(
                        Option("a", "Sirf sort option milta hai"),
                        Option("b", "Project, Sort aur Collation options milte hain"),
                        Option("c", "Delete aur backup options milte hain"),
                        Option("d", "Atlas account settings milti hain")
                    ),
                    correctOptionId = "b",
                    explanation = "Data Explorer mein Options button se Project (fields select karo), Sort (order decide karo) aur Collation (language-specific rules) teen options milte hain."
                ),
                Question(
                    id = "ch4mq2_3",
                    questionText = "Compass ka Data Explorer, Atlas Data Explorer se kaise compare karta hai?",
                    options = listOf(
                        Option("a", "Compass mein filter nahi hota, sirf atlas mein hota hai"),
                        Option("b", "Dono kaafi similar hain — same filter syntax, same options"),
                        Option("c", "Compass mein SQL use hota hai, Atlas mein JSON"),
                        Option("d", "Dono bilkul alag interfaces hain koi similarity nahi")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB Compass aur Atlas dono mein Data Explorer view kaafi similar hai — same filter box, same JSON syntax, same options (Project, Sort, Collation). GUI alag dikhti hai lekin kaam same hai."
                ),
            ),
            "it_mongo_ch4_m1" to listOf(
                Question(
                    id = "ch4mq1_1",
                    questionText = "find() aur findOne() mein kya fark hai?",
                    options = listOf(
                        Option("a", "findOne() sirf Atlas mein kaam karta hai"),
                        Option("b", "find() ek document deta hai, findOne() saare documents"),
                        Option("c", "findOne() pehla matching document deta hai, find() cursor deta hai (20-20 documents)"),
                        Option("d", "Dono bilkul same hain, koi fark nahi")
                    ),
                    correctOptionId = "c",
                    explanation = "findOne() collection ka pehla matching document return karta hai. find() ek cursor return karta hai jisme 20 documents aate hain, phir 'it' type karke agle 20 milte hain — jab tak saare documents iterate nahi ho jaate."
                ),
                Question(
                    id = "ch4mq1_2",
                    questionText = "db.grades.find() ke baad 'type it for more' dikhne par kya karna chahiye?",
                    options = listOf(
                        Option("a", "Query dobara run karni hai"),
                        Option("b", "'it' type karo — agle 20 documents aayenge"),
                        Option("c", "Naya terminal open karo"),
                        Option("d", "'more' type karo")
                    ),
                    correctOptionId = "b",
                    explanation = "'it' ka matlab iterate hai. find() ek cursor return karta hai aur 20 documents dikhata hai. Zyada chahiye to 'it' type karo — agle 20 aayenge. Ye tab tak chalta hai jab tak saare documents iterate nahi ho jaate."
                ),
                Question(
                    id = "ch4mq1_3",
                    questionText = "student_id=1 aur class_id=270 dono conditions ke saath query kaise likhenge?",
                    options = listOf(
                        Option("a", "db.grades.find({\"student_id\": 1} AND {\"class_id\": 270})"),
                        Option("b", "db.grades.find({\"student_id\": 1, \"class_id\": 270})"),
                        Option("c", "db.grades.find({\"student_id\": 1}).find({\"class_id\": 270})"),
                        Option("d", "db.grades.findBoth({\"student_id\": 1}, {\"class_id\": 270})")
                    ),
                    correctOptionId = "b",
                    explanation = "Multiple conditions ek hi curly braces mein comma se separate karke likhte hain. AND keyword ya alag find() chain nahi karte. Sahi syntax: db.grades.find({\"student_id\": 1, \"class_id\": 270})"
                ),
            ),
            "it_mongo_ch4_m6" to listOf(
                Question(
                    id = "ch4mq6_1",
                    questionText = "MQL mein \$ sign ka primary use kya hai?",
                    options = listOf(
                        Option("a", "Sirf numbers indicate karne ke liye"),
                        Option("b", "Operators aur field references ke liye prefix ki tarah"),
                        Option("c", "String values quote karne ke liye"),
                        Option("d", "Comments likhne ke liye")
                    ),
                    correctOptionId = "b",
                    explanation = "MQL mein \$ sign operators ke aage prefix hota hai (jaise \$gt, \$eq) aur field values refer karne ke liye bhi use hota hai (jaise '\$fieldname' in \$expr). Ye MQL ka grammar hai."
                ),
                Question(
                    id = "ch4mq6_2",
                    questionText = "db.trips.find({ tripduration: { \$gt: 300 } }) mein \$gt ka kya matlab hai?",
                    options = listOf(
                        Option("a", "tripduration 300 se kam ho"),
                        Option("b", "tripduration exactly 300 ho"),
                        Option("c", "tripduration 300 se zyada ho"),
                        Option("d", "tripduration 300 se zyada ya barabar ho")
                    ),
                    correctOptionId = "c",
                    explanation = "\$gt matlab 'greater than' — zyada se. Isliye { tripduration: { \$gt: 300 } } woh trips return karega jahan tripduration strictly 300 se zyada hai. Greater than or equal ke liye \$gte use hota hai."
                ),
                Question(
                    id = "ch4mq6_3",
                    questionText = "\$expr mein '\$fieldname' (with \$ prefix) ka kya matlab hai?",
                    options = listOf(
                        Option("a", "Literal string 'fieldname'"),
                        Option("b", "Field ka naam as a variable reference"),
                        Option("c", "Us document mein fieldname ki actual value"),
                        Option("d", "Ek regular expression pattern")
                    ),
                    correctOptionId = "c",
                    explanation = "\$expr mein jab '\$fieldname' likhte hain (dollar sign ke saath), to MongoDB us field ki actual runtime value use karta hai, na ki literal string 'fieldname'. Isi se do fields ko compare kar sakte hain same document mein."
                ),
            ),
            "it_mongo_ch4_m7" to listOf(
                Question(
                    id = "ch4mq7_1",
                    questionText = "db.trips.find({ tripduration: { \$in: [300, 400, 500] } }) kya return karega?",
                    options = listOf(
                        Option("a", "Trips jahan tripduration 300 aur 500 ke beech ho"),
                        Option("b", "Trips jahan tripduration exactly 300, 400, ya 500 ho"),
                        Option("c", "Trips jahan tripduration 300, 400, aur 500 se zyada ho"),
                        Option("d", "Trips jahan tripduration 300, 400, aur 500 se kam ho")
                    ),
                    correctOptionId = "b",
                    explanation = "\$in operator check karta hai ki field ki value given list mein se kisi ek ke barabar hai ya nahi. Is case mein tripduration exactly 300, 400, ya 500 hona chahiye."
                ),
                Question(
                    id = "ch4mq7_2",
                    questionText = "Companies ki query jo 2000 se baad founded hui ho, sahi syntax kaunsa hai?",
                    options = listOf(
                        Option("a", "db.companies.find({ founded_year: 2000 })"),
                        Option("b", "db.companies.find({ founded_year: { \$gt: 2000 } })"),
                        Option("c", "db.companies.find({ founded_year: { \$lt: 2000 } })"),
                        Option("d", "db.companies.find({ founded_year: { \$eq: 2000 } })")
                    ),
                    correctOptionId = "b",
                    explanation = "'2000 se baad' matlab strictly greater than 2000, isliye \$gt use hoga. \$gte use karte agar 2000 bhi include karna hota. \$lt ulta direction hai (2000 se pehle)."
                ),
                Question(
                    id = "ch4mq7_3",
                    questionText = "\$nin operator kab use karte hain?",
                    options = listOf(
                        Option("a", "Jab field ki value given list mein se kisi ek ke barabar ho"),
                        Option("b", "Jab field ki value given list mein se kisi bhi ke barabar NA ho"),
                        Option("c", "Jab field exist na kare document mein"),
                        Option("d", "Jab field ka value null ho")
                    ),
                    correctOptionId = "b",
                    explanation = "\$nin = 'Not IN' — ye woh documents return karta hai jahan field ki value given array mein se kisi bhi value ke barabar nahi hai. \$in ka ulta operator hai."
                ),
            ),
            "it_mongo_ch4_m8" to listOf(
                Question(
                    id = "ch4mq8_1",
                    questionText = "Implicit \$and kab kaam karta hai (bina \$and keyword ke)?",
                    options = listOf(
                        Option("a", "Jab alag alag fields pe conditions hon, ek hi document mein"),
                        Option("b", "Jab ek hi field pe do conditions hon"),
                        Option("c", "Sirf jab 3 se zyada conditions hon"),
                        Option("d", "Kabhi nahi, hamesha explicit \$and chahiye")
                    ),
                    correctOptionId = "a",
                    explanation = "Jab different fields pe conditions ek hi curly braces mein likhte hain, MongoDB automatically AND apply karta hai. Lekin agar ek hi field pe do conditions chahiye to explicit \$and zaroori hai (ya shorthand: {field: {\$gt: x, \$lt: y}})."
                ),
                Question(
                    id = "ch4mq8_2",
                    questionText = "\$nor operator ka kya matlab hai?",
                    options = listOf(
                        Option("a", "Koi ek condition true honi chahiye"),
                        Option("b", "Saari conditions true honi chahiye"),
                        Option("c", "Koi bhi condition true nahi honi chahiye"),
                        Option("d", "Pehli condition true, baaki false")
                    ),
                    correctOptionId = "c",
                    explanation = "\$nor matlab 'Neither OR' — ye woh documents return karta hai jahan koi bhi condition match nahi hoti. Ye \$or ka opposite hai. Agar koi bhi condition true hoti hai, document exclude ho jaata hai."
                ),
                Question(
                    id = "ch4mq8_3",
                    questionText = "Ek hi field pe do conditions (e.g., score > 50 AND score < 80) likhne ka sahi tarika kya hai?",
                    options = listOf(
                        Option("a", "{ score: { \$gt: 50 }, score: { \$lt: 80 } }"),
                        Option("b", "{ \$and: [{ score: { \$gt: 50 } }, { score: { \$lt: 80 } }] }"),
                        Option("c", "{ score: \$gt: 50, \$lt: 80 }"),
                        Option("d", "{ score: \$between: [50, 80] }")
                    ),
                    correctOptionId = "b",
                    explanation = "Jab ek hi field pe do conditions lagani ho, explicit \$and use karo. Ya shorthand: { score: { \$gt: 50, \$lt: 80 } } — dono equivalent hain. Option (a) kaam nahi karega kyunki duplicate key hogi JSON mein."
                ),
            ),
            "it_mongo_ch4_m9" to listOf(
                Question(
                    id = "ch4mq9_1",
                    questionText = "\$expr ka main use case kya hai?",
                    options = listOf(
                        Option("a", "Fixed value se field compare karna"),
                        Option("b", "Ek field ko doosre field se compare karna same document mein"),
                        Option("c", "Multiple collections ko join karna"),
                        Option("d", "Documents ko sort karna")
                    ),
                    correctOptionId = "b",
                    explanation = "\$expr allow karta hai ki ek field ki value ko doosre field ki value se compare karo — same document ke andar. Normal operators (jaise \$gt) sirf fixed values se compare kar sakte hain, isliye \$expr special hai."
                ),
                Question(
                    id = "ch4mq9_2",
                    questionText = "db.trips.find({ \$expr: { \$eq: [\"\$start station name\", \"\$end station name\"] } }) kya return karega?",
                    options = listOf(
                        Option("a", "Saari trips jahan start station koi bhi ho"),
                        Option("b", "Trips jahan start aur end station ka naam same ho"),
                        Option("c", "Trips jahan start station 'end station name' ho"),
                        Option("d", "Saari trips jahan end station exist kare")
                    ),
                    correctOptionId = "b",
                    explanation = "Ye query woh trips return karti hai jahan cyclist same station se shuru karke wapas same station pe aaya (circular trip). \$expr ke andar \$eq do field references compare karta hai: '\$start station name' aur '\$end station name'."
                ),
                Question(
                    id = "ch4mq9_3",
                    questionText = "\$expr mein '\$salary' (with \$) aur 'salary' (without \$) mein kya fark hai?",
                    options = listOf(
                        Option("a", "Dono same hain, koi fark nahi"),
                        Option("b", "'\$salary' = salary field ki runtime value; 'salary' = literal string 'salary'"),
                        Option("c", "'\$salary' = string 'salary'; '\$salary' numbers ke liye hai"),
                        Option("d", "'\$salary' sirf aggregation mein kaam karta hai, \$expr mein nahi")
                    ),
                    correctOptionId = "b",
                    explanation = "MQL mein \$ prefix field reference hai. '\$salary' matlab us document ki salary field ki actual value use karo. 'salary' (bina \$) ek literal string hai jiska value 'salary' text hai. \$expr mein hamesha field references \$ ke saath likhte hain."
                ),
            ),
            "it_mongo_ch4_m10" to listOf(
                Question(
                    id = "ch4mq10_1",
                    questionText = "inspections collection mein result = 'Pass' ya result = 'Fail' wale documents ki query kaunsi hai?",
                    options = listOf(
                        Option("a", "db.inspections.find({ result: 'Pass', result: 'Fail' })"),
                        Option("b", "db.inspections.find({ result: { \$in: ['Pass', 'Fail'] } })"),
                        Option("c", "db.inspections.find({ result: { \$gt: 'Pass' } })"),
                        Option("d", "db.inspections.find({ \$not: { result: 'None' } })")
                    ),
                    correctOptionId = "b",
                    explanation = "\$in operator ek list of values accept karta hai aur woh documents return karta hai jahan field ki value list mein se kisi ek ke barabar ho. Duplicate keys (option a) JSON mein invalid hai."
                ),
                Question(
                    id = "ch4mq10_2",
                    questionText = "\$in aur \$or mein kya practical fark hai?",
                    options = listOf(
                        Option("a", "\$in sirf numbers ke saath kaam karta hai, \$or strings ke saath"),
                        Option("b", "\$or alag alag fields pe conditions combine karta hai, \$in ek hi field ki multiple values check karta hai"),
                        Option("c", "\$in zyada operators support karta hai"),
                        Option("d", "Koi fark nahi, dono exact same hain")
                    ),
                    correctOptionId = "b",
                    explanation = "\$in ek hi field ke multiple possible values ke liye best hai — concise syntax. \$or kisi bhi combination ke liye use ho sakta hai, including different fields. Jab ek hi field ki multiple values check karni ho, \$in preferred hai."
                ),
                Question(
                    id = "ch4mq10_3",
                    questionText = "companies collection mein founded_year 1990 aur 2000 ke beech (inclusive) ki query kya hai?",
                    options = listOf(
                        Option("a", "db.companies.find({ founded_year: { \$gt: 1990, \$lt: 2000 } })"),
                        Option("b", "db.companies.find({ founded_year: { \$gte: 1990, \$lte: 2000 } })"),
                        Option("c", "db.companies.find({ \$between: { founded_year: [1990, 2000] } })"),
                        Option("d", "db.companies.find({ \$and: [{ founded_year: 1990 }, { founded_year: 2000 }] })")
                    ),
                    correctOptionId = "b",
                    explanation = "'Inclusive' matlab 1990 aur 2000 dono include hone chahiye. Isliye \$gte (greater than or equal) aur \$lte (less than or equal) use karenge. \$gt aur \$lt (bina 'e') strict comparisons hain jo endpoints exclude karte hain."
                ),
            ),
            "it_mongo_ch4_m11" to listOf(
                Question(
                    id = "ch4mq11_1",
                    questionText = "MongoDB mein array field query karte waqt sirf ek value dhundne ke liye kya likhte hain?",
                    options = listOf(
                        Option("a", "db.posts.find({ tags: { \$contains: \"Ruth\" } })"),
                        Option("b", "db.posts.find({ tags: \"Ruth\" })"),
                        Option("c", "db.posts.find({ tags: [\$eq: \"Ruth\"] })"),
                        Option("d", "db.posts.find({ tags.value: \"Ruth\" })")
                    ),
                    correctOptionId = "b",
                    explanation = "Array field mein ek value dhundne ke liye simply { field: value } likhte hain — koi special syntax nahi chahiye. MongoDB automatically array ke har element mein us value ko dhundta hai. Agar array mein \"Ruth\" hai, document return hoga."
                ),
                Question(
                    id = "ch4mq11_2",
                    questionText = "\$all aur exact array match mein kya fark hai?",
                    options = listOf(
                        Option("a", "\$all aur exact match dono same kaam karte hain"),
                        Option("b", "Exact match mein order aur saare elements match hone chahiye; \$all mein sirf specified values present honi chahiye (order free, extra elements allowed)"),
                        Option("c", "\$all mein order matter karta hai, exact match mein nahi"),
                        Option("d", "Exact match aur \$all dono mein order matter karta hai")
                    ),
                    correctOptionId = "b",
                    explanation = "Exact match: { tags: [\"a\", \"b\"] } — array bilkul same hona chahiye (same order, same elements). \$all: { tags: { \$all: [\"a\", \"b\"] } } — sirf ye dono values present honi chahiye, order free hai aur extra elements allowed hain."
                ),
                Question(
                    id = "ch4mq11_3",
                    questionText = "\$elemMatch kab use karna chahiye?",
                    options = listOf(
                        Option("a", "Jab array mein sirf ek value dhundni ho"),
                        Option("b", "Jab array ka exact match chahiye ho"),
                        Option("c", "Jab array of embedded documents mein multiple conditions ek SAME element pe apply karni ho"),
                        Option("d", "Jab array ka size check karna ho")
                    ),
                    correctOptionId = "c",
                    explanation = "\$elemMatch ensure karta hai ki dono conditions ek hi array element pe apply hon. Bina \$elemMatch ke, MongoDB conditions alag-alag elements pe check karta hai — galat results aa sakte hain. Example: type=exam AUR score>80 dono same score object mein hone chahiye."
                ),
            ),
            "it_mongo_ch4_m12" to listOf(
                Question(
                    id = "ch4mq12_1",
                    questionText = "sort() method mein -1 ka kya matlab hai?",
                    options = listOf(
                        Option("a", "Ascending order (A se Z)"),
                        Option("b", "Descending order (Z se A)"),
                        Option("c", "Random order"),
                        Option("d", "Sirf numeric fields ke liye sort")
                    ),
                    correctOptionId = "b",
                    explanation = "sort() mein 1 = ascending (A→Z, 0→9) aur -1 = descending (Z→A, 9→0). Strings pe alphabetical, numbers pe numerical, dates pe date order mein sort hota hai."
                ),
                Question(
                    id = "ch4mq12_2",
                    questionText = "count() aur size() mein practical fark kya hai?",
                    options = listOf(
                        Option("a", "Dono bilkul same hain, koi fark nahi"),
                        Option("b", "count() result set ki count deta hai; size() limit()/skip() ke baad actual returned documents count deta hai"),
                        Option("c", "size() fast hai, count() slow hai"),
                        Option("d", "count() sirf numbers ke liye hai")
                    ),
                    correctOptionId = "b",
                    explanation = "count() matching documents ki total count deta hai (limit/skip ignore karke). size() limit() ya skip() apply hone ke baad jo documents actually return hue unki count deta hai. Isliye limit ke saath size() zyada accurate hota hai."
                ),
                Question(
                    id = "ch4mq12_3",
                    questionText = "MongoDB shell mein ek baar mein kitne documents return hote hain, aur agle batch ke liye kya karte hain?",
                    options = listOf(
                        Option("a", "50 documents; 'next' type karo"),
                        Option("b", "20 documents; 'it' type karo"),
                        Option("c", "100 documents; 'more' type karo"),
                        Option("d", "10 documents; Enter press karo")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB shell ek baar mein sirf 20 documents return karta hai. Agle 20 documents dekhne ke liye shell mein 'it' (iterate) type karte hain. Tab tak karte raho jab tak saare documents na dekh lo."
                ),
            ),
            "it_mongo_ch4_m13" to listOf(
                Question(
                    id = "ch4mq13_1",
                    questionText = "Embedded field 'address.zip' ko query karne ka sahi syntax kaunsa hai?",
                    options = listOf(
                        Option("a", "db.inspections.find({ zip: 11427 })"),
                        Option("b", "db.inspections.find({ address: { zip: 11427 } })"),
                        Option("c", "db.inspections.find({ \"address.zip\": 11427 })"),
                        Option("d", "db.inspections.find({ address[zip]: 11427 })")
                    ),
                    correctOptionId = "c",
                    explanation = "Dot notation use karte hain embedded fields ke liye: \"parent.child\" format mein, poori string quotes ke andar. Option (a) kaam nahi karega kyunki zip top-level pe nahi hai. Option (b) exact document match karta hai jo usually expected nahi hota."
                ),
                Question(
                    id = "ch4mq13_2",
                    questionText = "3 levels deep field { a: { b: { c: \"value\" } } } ko dot notation se kaise query karenge?",
                    options = listOf(
                        Option("a", "{ a.b.c: \"value\" }"),
                        Option("b", "{ \"a/b/c\": \"value\" }"),
                        Option("c", "{ \"a.b.c\": \"value\" }"),
                        Option("d", "{ a: { b: { c: \"value\" } } }")
                    ),
                    correctOptionId = "c",
                    explanation = "Multi-level nesting ke liye dot notation: \"parent.child.grandchild\" — poori string quotes mein. Option (a) mein quotes nahi hain jo error dega. Option (d) exact embedded document match hai — kaam karta hai par flexible nahi hai."
                ),
                Question(
                    id = "ch4mq13_3",
                    questionText = "Top-level field 'result' ko query karne ke liye kya likhenge?",
                    options = listOf(
                        Option("a", "{ \"result\": \"No Violation Issued\" }"),
                        Option("b", "{ \".result\": \"No Violation Issued\" }"),
                        Option("c", "{ top.result: \"No Violation Issued\" }"),
                        Option("d", "{ result.value: \"No Violation Issued\" }")
                    ),
                    correctOptionId = "a",
                    explanation = "Top-level fields ke liye directly field ka naam likhte hain — dot notation ki zarurat nahi. Sirf tab dot notation use hota hai jab field kisi doosre field ke andar nested ho."
                ),
            ),
            "it_mongo_ch4_m14" to listOf(
                Question(
                    id = "ch4mq14_1",
                    questionText = "{ IPO: { \$exists: false } } kya return karega?",
                    options = listOf(
                        Option("a", "Woh documents jahan IPO = false ho"),
                        Option("b", "Woh documents jahan IPO field missing ho"),
                        Option("c", "Woh documents jahan IPO = null ho"),
                        Option("d", "Koi document nahi milega")
                    ),
                    correctOptionId = "b",
                    explanation = "\$exists: false woh documents return karta hai jahan woh field bilkul exist hi nahi karta — field document mein present nahi hai. Ye IPO=false se alag hai (jo field ki value false hone ka check hai)."
                ),
                Question(
                    id = "ch4mq14_2",
                    questionText = "\$type: 2 ka kya matlab hai?",
                    options = listOf(
                        Option("a", "Field Boolean type ka hai"),
                        Option("b", "Field Integer type ka hai"),
                        Option("c", "Field String type ka hai"),
                        Option("d", "Field Array type ka hai")
                    ),
                    correctOptionId = "c",
                    explanation = "BSON type codes: Double=1, String=2, Object=3, Array=4, Boolean=8, Null=10, Integer=16. Isliye \$type: 2 String type ko indicate karta hai."
                ),
                Question(
                    id = "ch4mq14_3",
                    questionText = "{ age: null } aur { age: { \$exists: true, \$eq: null } } mein kya fark hai?",
                    options = listOf(
                        Option("a", "Dono exactly same documents return karte hain"),
                        Option("b", "{ age: null } age=null AUR age missing dono match karta hai; combined query sirf woh match karta hai jahan field present ho AUR value null ho"),
                        Option("c", "{ age: null } galat syntax hai"),
                        Option("d", "\$exists aur null same kaam karte hain")
                    ),
                    correctOptionId = "b",
                    explanation = "{ age: null } broad match hai — age=null wale documents AUR age field missing wale documents dono return hote hain. Jab tum \$exists: true + \$eq: null combine karo, to sirf woh documents milte hain jahan field present ho (missing nahi) aur value null ho — precise check."
                ),
            ),
            "it_mongo_ch4_m15" to listOf(
                Question(
                    id = "ch4mq15_1",
                    questionText = "find() mein projection ka kya kaam hai?",
                    options = listOf(
                        Option("a", "Documents ko sort karna"),
                        Option("b", "Result mein kaunse fields dikhenge ya nahi ye decide karna"),
                        Option("c", "Documents ko filter karna"),
                        Option("d", "Documents count karna")
                    ),
                    correctOptionId = "b",
                    explanation = "Projection find() ka doosra parameter hai jo decide karta hai ki result set mein kaunse fields include ya exclude honge. Pehla parameter query (filter) hota hai, doosra projection (field selection)."
                ),
                Question(
                    id = "ch4mq15_2",
                    questionText = "_id field ke baare mein kya sach hai?",
                    options = listOf(
                        Option("a", "_id kabhi bhi return nahi hota"),
                        Option("b", "_id sirf tab return hota hai jab explicitly 1 do"),
                        Option("c", "_id by default return hota hai; hatane ke liye _id: 0 explicitly likhna padta hai"),
                        Option("d", "_id projection mein specify nahi kar sakte")
                    ),
                    correctOptionId = "c",
                    explanation = "_id ek special field hai — ye by default har result mein aata hai chahe tum projection mein specify karo ya na karo. Isko result se hatane ke liye explicitly { _id: 0 } likhna padta hai."
                ),
                Question(
                    id = "ch4mq15_3",
                    questionText = "{ name: 1, overview: 0 } projection kyun INVALID hai?",
                    options = listOf(
                        Option("a", "Kyunki name aur overview ek saath nahi ho sakte"),
                        Option("b", "Kyunki MongoDB mein ya to include mode (sab 1) ya exclude mode (sab 0) use hota hai — dono mix nahi kar sakte (_id ko chhod ke)"),
                        Option("c", "Kyunki overview field exist nahi karta"),
                        Option("d", "Kyunki projection mein 0 use nahi hota")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB projection mein include (1) aur exclude (0) mix nahi kar sakte — ye error deta hai. Exception sirf _id hai jise include mode mein bhi 0 se exclude kar sakte ho. Sahi: { name: 1, age: 1 } ya { overview: 0, desc: 0 } ya { name: 1, _id: 0 }."
                ),
            ),
            "it_mongo_ch4_m16" to listOf(
                Question(
                    id = "ch4mq16_1",
                    questionText = "db.users.deleteMany({}) command ka kya result hoga?",
                    options = listOf(
                        Option("a", "Koi document delete nahi hoga"),
                        Option("b", "Sirf pehla document delete hoga"),
                        Option("c", "users collection ke SAARE documents delete ho jayenge"),
                        Option("d", "users collection khud delete ho jayegi")
                    ),
                    correctOptionId = "c",
                    explanation = "deleteMany({}) mein empty filter {} matlab 'koi bhi condition nahi' — ye collection ke har document se match karta hai. Isliye saare documents delete ho jayenge. Ye ek bahut dangerous operation hai. Hamesha specific filter use karo jaise deleteMany({ status: 'inactive' })."
                ),
                Question(
                    id = "ch4mq16_2",
                    questionText = "MongoDB mein same document (same fields, same values) dobara insert karne par kya hoga?",
                    options = listOf(
                        Option("a", "Error aayega — duplicate document allowed nahi"),
                        Option("b", "Pehle wala document replace ho jayega"),
                        Option("c", "Naya document alag _id ke saath insert ho jayega"),
                        Option("d", "Insert silently ignore ho jayega")
                    ),
                    correctOptionId = "c",
                    explanation = "MongoDB mein same field values allowed hain — sirf _id unique hona chahiye. Jab tum same document dobara insert karte ho (bina _id specify kiye), MongoDB ek naya unique _id generate karta hai aur document successfully insert ho jata hai. Isliye collection mein 2 documents honge same fields ke saath lekin alag _id se."
                ),
                Question(
                    id = "ch4mq16_3",
                    questionText = "deleteOne() aur deleteMany() mein main difference kya hai?",
                    options = listOf(
                        Option("a", "deleteOne() fast hai aur deleteMany() slow"),
                        Option("b", "deleteOne() sirf pehla matching document delete karta hai; deleteMany() saare matching documents delete karta hai"),
                        Option("c", "deleteOne() embedded documents delete nahi kar sakta"),
                        Option("d", "deleteMany() sirf numeric fields pe kaam karta hai")
                    ),
                    correctOptionId = "b",
                    explanation = "deleteOne() filter se match karne wala sirf pehla document delete karta hai — chahe 100 matching documents ho. deleteMany() saare matching documents delete karta hai ek hi operation mein. Filter syntax dono mein same hota hai — bas scope alag hoti hai."
                ),
            ),
            "it_mongo_ch4_m17" to listOf(
                Question(
                    id = "ch4mq17_1",
                    questionText = "MongoDB mein agar collection exist nahi karti aur tum insert karo to kya hoga?",
                    options = listOf(
                        Option("a", "Error aayega — pehle collection create karni hogi"),
                        Option("b", "MongoDB automatically collection create kar deta hai aur document insert ho jata hai"),
                        Option("c", "Document temporarily store hoga jab tak collection manually create na ho"),
                        Option("d", "createCollection() call karna mandatory hai")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB schemaless aur flexible hai — agar collection exist nahi karti tab bhi insert() call kar sakte ho. MongoDB automatically collection implicitly create kar deta hai. Isliye createCollection() method use karne ki zarurat nahi hoti sirf insert ke liye."
                ),
                Question(
                    id = "ch4mq17_2",
                    questionText = "_id field ke baare mein kaunsa statement SAHI hai?",
                    options = listOf(
                        Option("a", "_id hamesha manually specify karni padti hai"),
                        Option("b", "_id automatically generate hoti hai, unique hoti hai, aur custom bhi de sakte ho"),
                        Option("c", "_id sirf string type ka ho sakta hai"),
                        Option("d", "Same _id wale 2 documents allowed hain alag collections mein bhi nahi")
                    ),
                    correctOptionId = "b",
                    explanation = "_id MongoDB ka primary key hai. Agar tum insert mein _id specify nahi karte to MongoDB automatically ek unique ObjectId generate karta hai. Tum apni custom _id bhi de sakte ho (number, string, kuch bhi) — bas wo unique honi chahiye us collection mein. Same _id dobara insert karne par Duplicate Key Error aata hai."
                ),
                Question(
                    id = "ch4mq17_3",
                    questionText = "Multiple documents ek saath insert karne ka sahi syntax kaunsa hai?",
                    options = listOf(
                        Option("a", "db.col.insert({doc1}, {doc2})"),
                        Option("b", "db.col.insertMany(doc1, doc2)"),
                        Option("c", "db.col.insert([{doc1}, {doc2}])"),
                        Option("d", "db.col.insert({doc1 + doc2})")
                    ),
                    correctOptionId = "c",
                    explanation = "Multiple documents insert karne ke liye insert() mein documents ka array pass karo — square brackets mein. Example: db.col.insert([{ name: 'A' }, { name: 'B' }]). insertMany() bhi kaam karta hai (modern syntax), lekin is lecture mein insert() with array cover kiya gaya hai."
                ),
            ),
            "it_mongo_ch4_m18" to listOf(
                Question(
                    id = "ch4mq18_1",
                    questionText = "Embedded field 'awards.academy' ke basis pe document delete karne ka sahi syntax kaunsa hai?",
                    options = listOf(
                        Option("a", "db.col.deleteOne({ awards: { academy: true } })"),
                        Option("b", "db.col.deleteOne({ \"awards.academy\": true })"),
                        Option("c", "db.col.deleteOne({ awards.academy: true })"),
                        Option("d", "db.col.deleteOne({ awards: true })")
                    ),
                    correctOptionId = "b",
                    explanation = "Embedded document fields access karne ke liye dot notation use hoti hai — aur field name ko double quotes mein likhna zaroori hai: { \"awards.academy\": true }. Yahi syntax find() mein bhi use hota hai. Option A exact embedded match dhundta hai (poora awards object match hona chahiye), jo alag hai."
                ),
                Question(
                    id = "ch4mq18_2",
                    questionText = "Delete filter aur find() filter mein kya relationship hai?",
                    options = listOf(
                        Option("a", "Delete filter alag syntax follow karta hai"),
                        Option("b", "Delete filter bilkul find() ki tarah kaam karta hai — sirf operation alag hai"),
                        Option("c", "Delete mein comparison operators use nahi ho sakte"),
                        Option("d", "Delete sirf _id field pe filter kar sakta hai")
                    ),
                    correctOptionId = "b",
                    explanation = "Delete filter aur find() filter identical hain — same syntax, same operators (\$gt, \$lt, dot notation, \$and, etc.). Difference sirf result mein hai: find() documents return karta hai, deleteOne()/deleteMany() matching documents delete karta hai. Isliye ek common pattern hai: pehle find() se verify karo, phir same filter se delete karo."
                ),
                Question(
                    id = "ch4mq18_3",
                    questionText = "deleteMany({ name: 'Tom Hanks' }) call karne se kya result hoga agar collection mein 5 matching documents hain?",
                    options = listOf(
                        Option("a", "Sirf pehla document delete hoga — deletedCount: 1"),
                        Option("b", "Koi document delete nahi hoga — deleteMany sirf empty filter se kaam karta hai"),
                        Option("c", "Saare 5 documents delete honge — deletedCount: 5"),
                        Option("d", "Error aayega kyunki name field pe delete nahi kar sakte")
                    ),
                    correctOptionId = "c",
                    explanation = "deleteMany() filter se match karne wale SAARE documents delete karta hai. Agar 5 documents hain jinka name = 'Tom Hanks', to deletedCount: 5 aayega. deleteOne() sirf pehle match wale pe rukta hai, deleteMany() nahi rukta. Isliye deleteMany() use karte waqt filter double-check karna zaroori hai."
                ),
            ),
            "it_mongo_ch5_m1" to listOf(
                Question(
                    id = "ch5mq1_1",
                    questionText = "updateOne() aur updateMany() mein kya difference hai?",
                    options = listOf(
                        Option("a", "updateOne() sirf _id se update karta hai, updateMany() kisi bhi field se"),
                        Option("b", "updateOne() pehle matching document update karta hai, updateMany() saare matching documents"),
                        Option("c", "updateOne() \$set use karta hai, updateMany() \$update use karta hai"),
                        Option("d", "Dono exactly same kaam karte hain")
                    ),
                    correctOptionId = "b",
                    explanation = "updateOne() sirf pehle matching document ko update karta hai aur ruk jaata hai. updateMany() filter se match hone wale SAARE documents update karta hai. Dono ka syntax aur operators (jaise \$set) same hain — sirf update ka scope alag hai."
                ),
                Question(
                    id = "ch5mq1_2",
                    questionText = "\$set operator kya karta hai?",
                    options = listOf(
                        Option("a", "Poora document replace kar deta hai nayi values se"),
                        Option("b", "Sirf specified fields update karta hai, baaki fields intact rehte hain"),
                        Option("c", "Document delete karke naya insert karta hai"),
                        Option("d", "Sirf _id field update kar sakta hai")
                    ),
                    correctOptionId = "b",
                    explanation = "\$set operator sirf un fields ko update karta hai jo tum specify karo. Baaki sab fields waise hi rehte hain. Agar field exist nahi karti, to \$set usse naya bana deta hai. Document replace nahi hota — ye partial update operator hai."
                ),
                Question(
                    id = "ch5mq1_3",
                    questionText = "Embedded field 'awards.academy' ko \$set se update karne ka sahi syntax kaunsa hai?",
                    options = listOf(
                        Option("a", "{ \$set: { awards: { academy: true } } }"),
                        Option("b", "{ \$set: { awards.academy: true } }"),
                        Option("c", "{ \$set: { \"awards.academy\": true } }"),
                        Option("d", "{ \$update: { \"awards.academy\": true } }")
                    ),
                    correctOptionId = "c",
                    explanation = "Embedded (nested) fields access karne ke liye dot notation use hoti hai aur field name ko double quotes mein likhna zaroori hai: { \$set: { \"awards.academy\": true } }. Option A poora awards object replace kar deta (grammy field hata deta). Option B quotes nahi hain — syntax error."
                ),
            ),
            "it_mongo_ch5_m2" to listOf(
                Question(
                    id = "ch5mq2_1",
                    questionText = "upsert: true ka kya matlab hota hai?",
                    options = listOf(
                        Option("a", "Sirf update hoga, insert kabhi nahi hoga"),
                        Option("b", "Agar filter se match mila to update karo, nahi mila to naya document insert karo"),
                        Option("c", "Naya document create karo aur phir update karo"),
                        Option("d", "Purana document delete karo aur nayi values se insert karo")
                    ),
                    correctOptionId = "b",
                    explanation = "upsert: true ek combined update + insert behavior hai. Agar filter se koi document match kare → wo update ho jaata hai. Agar koi match nahi mila → filter fields aur \$set fields combine hokar ek naya document insert hota hai. Ye tab useful hai jab pata nahi ki document exist karta hai ya nahi."
                ),
                Question(
                    id = "ch5mq2_2",
                    questionText = "upsert: false (default) behavior kya hai jab filter se koi match nahi milta?",
                    options = listOf(
                        Option("a", "Error throw karta hai"),
                        Option("b", "Empty document insert karta hai"),
                        Option("c", "Kuch nahi hota — matchedCount: 0, modifiedCount: 0"),
                        Option("d", "Filter ki value se naya document create karta hai")
                    ),
                    correctOptionId = "c",
                    explanation = "Default behavior (upsert: false) mein agar filter se koi document match nahi milta, to kuch bhi nahi hota — na koi error, na koi insert. Result mein matchedCount: 0 aur modifiedCount: 0 aata hai. Koi silent failure nahi hai, bas operation no-op ho jaata hai."
                ),
                Question(
                    id = "ch5mq2_3",
                    questionText = "upsert: true se naya document create hone par response mein kaunsa extra field aata hai?",
                    options = listOf(
                        Option("a", "insertedId"),
                        Option("b", "createdId"),
                        Option("c", "newDocumentId"),
                        Option("d", "upsertedId")
                    ),
                    correctOptionId = "d",
                    explanation = "Jab upsert: true se naya document create hota hai, to response mein upsertedId field aata hai jo naye document ka ObjectId hota hai. Saath mein upsertedCount: 1 bhi hota hai. insertedId sirf insertOne()/insertMany() operations ke response mein aata hai."
                ),
            ),
            "it_mongo_ch5_m3" to listOf(
                Question(
                    id = "ch5mq3_1",
                    questionText = "Atlas UI mein document edit mode kaise open karte hain?",
                    options = listOf(
                        Option("a", "Document pe double-click karo"),
                        Option("b", "Document ke paas pencil icon (✏️) pe click karo"),
                        Option("c", "Edit menu se 'Modify Document' select karo"),
                        Option("d", "F2 key press karo")
                    ),
                    correctOptionId = "b",
                    explanation = "Atlas Data Explorer mein har document ke paas ek pencil icon (✏️) hota hai. Usse click karne par document edit mode mein khulta hai jahan har field editable ban jaati hai. Yahan tum values change kar sakte ho, data types change kar sakte ho, aur naye fields add kar sakte ho."
                ),
                Question(
                    id = "ch5mq3_2",
                    questionText = "Bulk updates (100+ documents) ke liye kaunsa method better hai?",
                    options = listOf(
                        Option("a", "Atlas UI — ek ek karke manually edit karo"),
                        Option("b", "MongoDB Compass — drag and drop"),
                        Option("c", "Mongo Shell — updateMany() command"),
                        Option("d", "Atlas UI aur Shell dono same speed pe kaam karte hain")
                    ),
                    correctOptionId = "c",
                    explanation = "Bulk updates (bahut saare documents) ke liye Mongo Shell ka updateMany() best hai — ek command mein hazaron documents update ho sakte hain. Atlas UI ka pencil icon sirf single document ke liye practical hai; bulk operations ke liye UI se ek ek click karna impractical aur time-consuming hoga."
                ),
                Question(
                    id = "ch5mq3_3",
                    questionText = "Atlas UI mein kisi field ka data type String se Int32 mein kaise change karte hain?",
                    options = listOf(
                        Option("a", "Ye possible nahi — type change ke liye shell use karna padta hai"),
                        Option("b", "Edit mode mein field ke paas data type dropdown se nayi type select karo"),
                        Option("c", "Field delete karo aur naye type ke saath dobara add karo"),
                        Option("d", "Field name ke aage type likhna padta hai, jaise Int32:age")
                    ),
                    correctOptionId = "b",
                    explanation = "Atlas UI ka edit mode har field ke paas ek data type dropdown provide karta hai. Edit mode mein field ki value ke saath ek type selector hota hai — jaise String, Int32, Double, Boolean, Array, etc. Wahan se directly type change kiya ja sakta hai bina field delete kiye."
                ),
            ),
            "it_mongo_ch6_m1" to listOf(
                Question(
                    id = "ch6m1_1",
                    questionText = "Aggregation pipeline mein stages ka output kaise hota hai?",
                    options = listOf(
                        Option("a", "Har stage directly database mein save karta hai"),
                        Option("b", "Sab stages ka output ek saath combine hota hai"),
                        Option("c", "Pehle stage ka output doosre stage ka input hota hai"),
                        Option("d", "Last stage pehle execute hoti hai")
                    ),
                    correctOptionId = "c",
                    explanation = "Pipeline mein stages sequentially execute hote hain. Pehle stage ka output next stage ka input ban jaata hai — bilkul ek assembly line ki tarah. Isliye isko 'pipeline' kehte hain."
                ),
                Question(
                    id = "ch6m1_2",
                    questionText = "aggregate() command mein stages kaise pass kiye jaate hain?",
                    options = listOf(
                        Option("a", "Comma se alag individual arguments ke roop mein"),
                        Option("b", "Ek array ([]) mein stage objects ke roop mein"),
                        Option("c", "String ke roop mein"),
                        Option("d", "Curly braces mein directly bina array ke")
                    ),
                    correctOptionId = "b",
                    explanation = "aggregate() mein ek array pass kiya jaata hai jisme har stage ek object hota hai: db.collection.aggregate([{stage1}, {stage2}, ...]). Array ke andar har element ek stage object hai."
                ),
                Question(
                    id = "ch6m1_3",
                    questionText = "Aggregation Framework aur basic MQL mein kya mukhya fark hai?",
                    options = listOf(
                        Option("a", "MQL sirf insert karta hai, aggregation sirf read karta hai"),
                        Option("b", "Dono exactly same hain — koi fark nahi"),
                        Option("c", "Aggregation zyada powerful hai: filter, transform, group sab ek pipeline mein"),
                        Option("d", "MQL faster hai kyunki aggregation disk pe save karta hai")
                    ),
                    correctOptionId = "c",
                    explanation = "MQL basic CRUD ke liye hai (find, insert, update, delete). Aggregation Framework zyada powerful hai — complex transformations, grouping, calculations sab ek pipeline mein kar sakte ho."
                ),
            ),
            "it_mongo_ch6_m2" to listOf(
                Question(
                    id = "ch6m2_1",
                    questionText = "\$match stage ko pipeline mein kahan rakhna chahiye?",
                    options = listOf(
                        Option("a", "Pipeline ke bilkul end mein"),
                        Option("b", "Sirf \$group ke baad"),
                        Option("c", "Pipeline mein jitna pehle ho sake, sabse pehle"),
                        Option("d", "Koi fark nahi — performance same rahega")
                    ),
                    correctOptionId = "c",
                    explanation = "\$match ko sabse pehle rakhne se performance improve hoti hai — kam documents next stages tak pahunche, processing time aur resources dono bachte hain."
                ),
                Question(
                    id = "ch6m2_2",
                    questionText = "\$match aur find() mein kya mukhya fark hai?",
                    options = listOf(
                        Option("a", "\$match zyada slow hai"),
                        Option("b", "find() pipeline mein use hota hai, \$match collection par"),
                        Option("c", "\$match mein projection parameter nahi hoti"),
                        Option("d", "Dono exactly same hain, koi fark nahi")
                    ),
                    correctOptionId = "c",
                    explanation = "find() mein tum filter ke saath projection bhi de sakte ho (doosra parameter). \$match sirf filter karta hai — projection ke liye \$project stage alag lagti hai pipeline mein."
                ),
                Question(
                    id = "ch6m2_3",
                    questionText = "\$elemMatch kab use karte hain?",
                    options = listOf(
                        Option("a", "Jab puri collection match karni ho"),
                        Option("b", "Jab ek array element mein multiple conditions match karni hon"),
                        Option("c", "Jab do collections join karni hon"),
                        Option("d", "Jab sirf ek field check karni ho")
                    ),
                    correctOptionId = "b",
                    explanation = "\$elemMatch array mein kisi element par multiple conditions ek saath check karta hai. Example: scores array mein koi element jo type='exam' AND score > 85 ho — yahan \$elemMatch use hoga."
                ),
            ),
            "it_mongo_ch6_m3" to listOf(
                Question(
                    id = "ch6m3_1",
                    questionText = "\$project mein '_id: 0' likhne ka kya matlab hai?",
                    options = listOf(
                        Option("a", "_id field ko 0 value assign karo"),
                        Option("b", "_id field ko result mein se hide karo"),
                        Option("c", "_id ko update karo"),
                        Option("d", "_id ko delete karo")
                    ),
                    correctOptionId = "b",
                    explanation = "\$project mein 0 ka matlab exclude/hide hai. By default _id return hota hai, isliye agar nahi chahiye to explicitly '_id: 0' likhna padta hai."
                ),
                Question(
                    id = "ch6m3_2",
                    questionText = "Aggregation mein field name ke aage dollar sign (\$fieldName) kyun lagate hain?",
                    options = listOf(
                        Option("a", "Error se bachne ke liye"),
                        Option("b", "Field ki value reference karne ke liye"),
                        Option("c", "Field delete karne ke liye"),
                        Option("d", "Field ko optional banana ke liye")
                    ),
                    correctOptionId = "b",
                    explanation = "Aggregation mein '\$fieldName' ek field reference hai — yani 'is document ki is field ki value use karo'. Bina \$ ke, MongoDB isse ek literal string maanta hai, field ki value nahi."
                ),
                Question(
                    id = "ch6m3_3",
                    questionText = "Kya \$project original document ko permanently modify karta hai?",
                    options = listOf(
                        Option("a", "Haan, permanently field rename ho jaata hai"),
                        Option("b", "Haan, calculated fields save ho jaate hain"),
                        Option("c", "Nahi, \$project sirf output ko transform karta hai — underlying data same rehta hai"),
                        Option("d", "Depend karta hai — write: true flag lagao to save hota hai")
                    ),
                    correctOptionId = "c",
                    explanation = "\$project aggregation pipeline ka ek stage hai jo sirf output ko reshape karta hai. Ye original collection ke documents ko permanently modify NAHI karta. Data collection mein waise ka waisa rehta hai."
                ),
            ),
            "it_mongo_ch6_m4" to listOf(
                Question(
                    id = "ch6m4_1",
                    questionText = "MongoDB mein dates compare karne ke liye kya use karte hain?",
                    options = listOf(
                        Option("a", "DATEONLY() function"),
                        Option("b", "ISODate()"),
                        Option("c", "DATE_FORMAT()"),
                        Option("d", "TIMESTAMP()")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB mein dates ko ISODate() function se represent karte hain. Comparison operators (\$gt, \$gte, \$lt, \$lte) dates ke saath bhi kaam karte hain bilkul numbers ki tarah."
                ),
                Question(
                    id = "ch6m4_2",
                    questionText = "\$match mein ek hi object mein do fields likhne ka matlab kya hai?",
                    options = listOf(
                        Option("a", "OR condition — koi ek match karna chahiye"),
                        Option("b", "AND condition — dono match karne chahiye"),
                        Option("c", "NOT condition"),
                        Option("d", "Ye syntax wrong hai — error aayega")
                    ),
                    correctOptionId = "b",
                    explanation = "\$match (aur find()) mein ek object mein multiple fields likhne se implicit AND banta hai — yani dono conditions satisfy honi chahiye tab hi document aage pass hoga."
                ),
                Question(
                    id = "ch6m4_3",
                    questionText = "Aggregation mein 'HOUSTON' aur 'houston' — kya dono same result denge?",
                    options = listOf(
                        Option("a", "Haan, MongoDB case-insensitive hai"),
                        Option("b", "Nahi, string matching case-sensitive hai"),
                        Option("c", "Depend karta hai collection type par"),
                        Option("d", "Haan, aggregate() automatically lowercase karta hai")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB string matching by default case-sensitive hai. 'HOUSTON' sirf 'HOUSTON' se match karega, 'houston' ya 'Houston' se nahi. Isliye exact case likhna zaroori hai."
                ),
            ),
            "it_mongo_ch6_m5" to listOf(
                Question(
                    id = "ch6m5_1",
                    questionText = "\$match mein arithmetic expression operators use karne ke liye kya zaroori hai?",
                    options = listOf(
                        Option("a", "Kuch nahi — directly use kar sakte hain"),
                        Option("b", "\$expr wrapper"),
                        Option("c", "\$compute operator"),
                        Option("d", "\$eval wrapper")
                    ),
                    correctOptionId = "b",
                    explanation = "\$match mein expression operators directly kaam nahi karte. Inhe \$expr ke andar wrap karna padta hai. Bina \$expr ke query chalti hai, error nahi aata, lekin koi result nahi milta."
                ),
                Question(
                    id = "ch6m5_2",
                    questionText = "\$round operator ka sahi syntax kya hai?",
                    options = listOf(
                        Option("a", "\$round: number"),
                        Option("b", "\$round: { value: number, places: n }"),
                        Option("c", "\$round: [number, decimalPlaces]"),
                        Option("d", "\$round: (number, decimalPlaces)")
                    ),
                    correctOptionId = "c",
                    explanation = "\$round ek array leta hai: pehla element number aur doosra element decimal places ki count. Jaise: \$round: [{ \$divide: [\"\$tripduration\", 60] }, 1] — 1 decimal place tak round."
                ),
                Question(
                    id = "ch6m5_3",
                    questionText = "\$project mein arithmetic operators use karne ke liye kya zaroori hai?",
                    options = listOf(
                        Option("a", "\$expr wrapper zaroori hai"),
                        Option("b", "\$compute flag set karo"),
                        Option("c", "Kuch nahi — directly use kar sakte hain"),
                        Option("d", "Pipeline mein pehle \$group stage lagao")
                    ),
                    correctOptionId = "c",
                    explanation = "\$project mein expression operators (jaise \$divide, \$multiply, \$add) directly use kar sakte ho — \$expr ki zaroorat nahi hoti. Ye \$match se alag hai jahan \$expr compulsory hota hai."
                ),
            ),
            "it_mongo_ch6_m6" to listOf(
                Question(
                    id = "ch6m6_1",
                    questionText = "\$concat operator ka sahi syntax kaunsa hai?",
                    options = listOf(
                        Option("a", "\$concat: expression1, expression2"),
                        Option("b", "\$concat: [expression1, expression2, ...]"),
                        Option("c", "\$concat: { str1: expression1, str2: expression2 }"),
                        Option("d", "\$concat: (expression1, expression2)")
                    ),
                    correctOptionId = "b",
                    explanation = "\$concat ek array leta hai jisme multiple expressions ho sakte hain: { \$concat: [expr1, expr2, expr3] }. Dynamic field references aur static strings dono mix kar sakte ho — jaise [\"\$field\", \" - \", \"\$otherField\"]."
                ),
                Question(
                    id = "ch6m6_2",
                    questionText = "\$regexMatch operator ka result kya hota hai?",
                    options = listOf(
                        Option("a", "Pattern ki position return karta hai"),
                        Option("b", "Pattern ki count return karta hai"),
                        Option("c", "true ya false return karta hai"),
                        Option("d", "Matched string return karta hai")
                    ),
                    correctOptionId = "c",
                    explanation = "\$regexMatch sirf true ya false return karta hai — pattern mila to true, nahi mila to false. Ye aggregation pipeline mein boolean flag fields create karne ke kaam aata hai."
                ),
                Question(
                    id = "ch6m6_3",
                    questionText = "\$toUpper mein kitne expressions pass kiye jaate hain?",
                    options = listOf(
                        Option("a", "Ek array [expr1, expr2]"),
                        Option("b", "Ek object { field: value }"),
                        Option("c", "Ek single expression (jaise field reference)"),
                        Option("d", "Do arguments comma se separated")
                    ),
                    correctOptionId = "c",
                    explanation = "\$toUpper: expression — sirf ek expression leta hai (unlike \$concat jo array leta hai). Jaise: { \$toUpper: \"\$fieldName\" }. Similarly \$toLower bhi ek hi expression leta hai."
                ),
            ),
            "it_mongo_ch6_m7" to listOf(
                Question(
                    id = "ch6m7_1",
                    questionText = "\$dateAdd mein kaunsa field optional hai?",
                    options = listOf(
                        Option("a", "startDate"),
                        Option("b", "unit"),
                        Option("c", "amount"),
                        Option("d", "timezone")
                    ),
                    correctOptionId = "d",
                    explanation = "\$dateAdd ke required fields hain: startDate, unit, amount. timezone optional hai. Bina timezone ke bhi \$dateAdd kaam karta hai."
                ),
                Question(
                    id = "ch6m7_2",
                    questionText = "\$month operator January date ke liye kya return karta hai?",
                    options = listOf(
                        Option("a", "String \"January\""),
                        Option("b", "0"),
                        Option("c", "1"),
                        Option("d", "String \"01\"")
                    ),
                    correctOptionId = "c",
                    explanation = "\$month date ka month NUMBER return karta hai — January = 1, February = 2, ... December = 12. String nahi, integer return hota hai."
                ),
                Question(
                    id = "ch6m7_3",
                    questionText = "\$dateDiff ke liye kaunse fields zaroori hain?",
                    options = listOf(
                        Option("a", "startDate, endDate, unit, timezone"),
                        Option("b", "startDate, endDate, unit"),
                        Option("c", "startDate, unit, amount"),
                        Option("d", "startDate, endDate")
                    ),
                    correctOptionId = "b",
                    explanation = "\$dateDiff ke 3 required fields hain: startDate, endDate, unit. timezone aur startOfWeek optional hain. Amount \$dateAdd mein hota hai, \$dateDiff mein nahi."
                ),
            ),
            "it_mongo_ch6_m8" to listOf(
                Question(
                    id = "ch6m8_1",
                    questionText = "Aggregation expression operator \$gt ka sahi syntax kya hai?",
                    options = listOf(
                        Option("a", "{ field: { \$gt: value } }"),
                        Option("b", "{ \$gt: value }"),
                        Option("c", "{ \$gt: [expression1, expression2] }"),
                        Option("d", "\$gt(expression1, expression2)")
                    ),
                    correctOptionId = "c",
                    explanation = "Expression operators array-based syntax use karte hain: { \$gt: [expr1, expr2] }. Ye MQL query syntax { field: { \$gt: value } } se alag hai. \$project mein sirf expression syntax kaam karta hai."
                ),
                Question(
                    id = "ch6m8_2",
                    questionText = "\$project mein MQL query syntax { tripduration: { \$gt: 100 } } use karne se kya hoga?",
                    options = listOf(
                        Option("a", "Sahi kaam karega"),
                        Option("b", "Warning aayega lekin kaam karega"),
                        Option("c", "Error aayega"),
                        Option("d", "Silently ignore ho jaayega")
                    ),
                    correctOptionId = "c",
                    explanation = "\$project stage sirf expression syntax accept karta hai: { \$gt: [expr1, expr2] }. Agar MQL query syntax use karo to error aayega kyunki \$project expression operators ko hi support karta hai, query operators ko nahi."
                ),
                Question(
                    id = "ch6m8_3",
                    questionText = "\$project mein { \$gt: [\"\$tripduration\", 100] } ka result kya hoga?",
                    options = listOf(
                        Option("a", "1 ya 0 (integer)"),
                        Option("b", "\"true\" ya \"false\" (string)"),
                        Option("c", "true ya false (boolean)"),
                        Option("d", "Sirf matching documents return karega")
                    ),
                    correctOptionId = "c",
                    explanation = "Comparison expression operators (jaise \$gt, \$lt, \$eq) \$project mein use karne par boolean true/false return karte hain. Isliye ye boolean flag fields create karne ke kaam aate hain — jaise over_100_flag: true/false."
                ),
            ),
            "it_mongo_ch6_m9" to listOf(
                Question(
                    id = "ch6m9_1",
                    questionText = "\$map operator ke andar current element ko access karne ke liye kaunsa prefix use hota hai?",
                    options = listOf(
                        Option("a", "\$ (single dollar)"),
                        Option("b", "\$\$ (double dollar)"),
                        Option("c", "@ (at sign)"),
                        Option("d", "# (hash)")
                    ),
                    correctOptionId = "b",
                    explanation = "\$map mein 'as' se define kiye gaye variable ko access karne ke liye \$\$ (double dollar) prefix use hota hai. Jaise as: 'price' define kiya to access: \$\$price. Single \$ regular field reference ke liye hota hai."
                ),
                Question(
                    id = "ch6m9_2",
                    questionText = "\$arrayElemAt operator ka syntax kya hai?",
                    options = listOf(
                        Option("a", "{ \$arrayElemAt: { array: expr, index: N } }"),
                        Option("b", "{ \$arrayElemAt: [array, index] }"),
                        Option("c", "{ \$arrayElemAt: (array, index) }"),
                        Option("d", "{ \$arrayElemAt: array.index }")
                    ),
                    correctOptionId = "b",
                    explanation = "\$arrayElemAt array-based syntax use karta hai: [ <array>, <index> ]. Index 0-based hota hai, aur negative values end se count karte hain (-1 = last element)."
                ),
                Question(
                    id = "ch6m9_3",
                    questionText = "\$size operator use karne se pehle kya check karna chahiye?",
                    options = listOf(
                        Option("a", "Field ka type string hai ya nahi"),
                        Option("b", "Field null hai ya nahi"),
                        Option("c", "Field array hai ya nahi (\$isArray se)"),
                        Option("d", "Field ka value 0 se bada hai ya nahi")
                    ),
                    correctOptionId = "c",
                    explanation = "\$size sirf array fields par kaam karta hai. Agar field array nahi hai to error aayega. Isliye safe approach hai \$isArray se pehle check karo, phir \$cond ke saath \$size use karo."
                ),
            ),
            "it_mongo_ch6_m10" to listOf(
                Question(
                    id = "ch6m10_1",
                    questionText = "\$cond operator ke dono valid syntaxes kaunse hain?",
                    options = listOf(
                        Option("a", "Array syntax aur object syntax { if, then, else }"),
                        Option("b", "String syntax aur number syntax"),
                        Option("c", "Query syntax aur expression syntax"),
                        Option("d", "Inline syntax aur pipeline syntax")
                    ),
                    correctOptionId = "a",
                    explanation = "\$cond do syntaxes support karta hai: (1) Array: [ condition, ifTrue, ifFalse ] aur (2) Object: { if: condition, then: value, else: value }. Dono equivalent hain; object syntax zyada readable hota hai."
                ),
                Question(
                    id = "ch6m10_2",
                    questionText = "\$ifNull operator ka kya kaam hai?",
                    options = listOf(
                        Option("a", "Field delete karta hai agar null ho"),
                        Option("b", "Null ya missing field ko replacement value se replace karta hai"),
                        Option("c", "Sirf null values ko 0 se replace karta hai"),
                        Option("d", "Field existence check karta hai aur boolean return karta hai")
                    ),
                    correctOptionId = "b",
                    explanation = "\$ifNull: [ expression, replacement ] — agar expression null ya missing hai to replacement value return karta hai. Warna expression ki actual value. Ye null aur missing dono cases handle karta hai."
                ),
                Question(
                    id = "ch6m10_3",
                    questionText = "\$switch mein koi bhi branch match na ho aur default na ho to kya hoga?",
                    options = listOf(
                        Option("a", "null return hoga"),
                        Option("b", "0 return hoga"),
                        Option("c", "Error aayega"),
                        Option("d", "Empty string return hogi")
                    ),
                    correctOptionId = "c",
                    explanation = "\$switch mein agar koi branch match nahi karta aur default field define nahi ki gayi hai to error aayega. Isliye hamesha default specify karna best practice hai unexpected values handle karne ke liye."
                ),
            ),
            "it_mongo_ch6_m11" to listOf(
                Question(
                    id = "ch6m11_1",
                    questionText = "\$concatArrays operator mein input kya hona chahiye?",
                    options = listOf(
                        Option("a", "Sirf ek array"),
                        Option("b", "Arrays ka array (each element ek array ho)"),
                        Option("c", "Comma-separated values"),
                        Option("d", "Object with array fields")
                    ),
                    correctOptionId = "b",
                    explanation = "\$concatArrays ek array of arrays leta hai: { \$concatArrays: [array1, array2, ...] }. Har element khud ek array hona chahiye. Ye sab arrays ko ek single array mein combine karta hai."
                ),
                Question(
                    id = "ch6m11_2",
                    questionText = "\$first operator kya return karta hai?",
                    options = listOf(
                        Option("a", "Array ka maximum value"),
                        Option("b", "Array ka pehla element"),
                        Option("c", "Group ka pehla document ki field"),
                        Option("d", "B aur C dono contexts mein use ho sakta hai")
                    ),
                    correctOptionId = "d",
                    explanation = "\$first do contexts mein use hota hai: (1) Array expression: array ka pehla element return karta hai, jaise \$arrayElemAt with index 0. (2) Group accumulator: sort ke baad group ka pehla document ki value. Context pe depend karta hai."
                ),
                Question(
                    id = "ch6m11_3",
                    questionText = "\$map ke andar 'as' field ka purpose kya hai?",
                    options = listOf(
                        Option("a", "Output field ka naam define karna"),
                        Option("b", "Variable naam define karna jo current element represent kare"),
                        Option("c", "Input array alias banana"),
                        Option("d", "Expression type specify karna")
                    ),
                    correctOptionId = "b",
                    explanation = "\$map mein 'as' field variable naam define karta hai jo current array element represent karta hai. Is variable ko 'in' expression mein \$\$ prefix ke saath access karte hain. Jaise as: 'item' → access: \$\$item."
                ),
            ),
            "it_mongo_ch6_m12" to listOf(
                Question(
                    id = "ch6m12_1",
                    questionText = "\$addFields aur \$project mein main difference kya hai?",
                    options = listOf(
                        Option("a", "Koi difference nahi, dono same hain"),
                        Option("b", "\$addFields existing fields preserve karta hai, \$project nahi"),
                        Option("c", "\$project existing fields preserve karta hai, \$addFields nahi"),
                        Option("d", "\$addFields sirf string fields add kar sakta hai")
                    ),
                    correctOptionId = "b",
                    explanation = "\$addFields nayi fields add karta hai lekin existing sab fields preserve rakhta hai. \$project mein explicitly list karna padta hai konsi fields rakhnii hain. Agar sirf nayi fields add karni hain bina existing exclude kiye — \$addFields use karo."
                ),
                Question(
                    id = "ch6m12_2",
                    questionText = "\$addFields mein nested field add karne ke liye kaunsa syntax use hota hai?",
                    options = listOf(
                        Option("a", "{ nested: { field: value } }"),
                        Option("b", "{ \"parent.child\": value } (dot notation)"),
                        Option("c", "{ nested[field]: value }"),
                        Option("d", "{ \$nested: { parent: field } }")
                    ),
                    correctOptionId = "b",
                    explanation = "\$addFields mein nested fields add karne ke liye dot notation use hoti hai: { \"contact.fullAddress\": expression }. Isse existing 'contact' object mein 'fullAddress' field add ho jaati hai bina baaki contact fields ko affect kiye."
                ),
                Question(
                    id = "ch6m12_3",
                    questionText = "\$addFields pipeline mein kahan use ho sakta hai?",
                    options = listOf(
                        Option("a", "Sirf pehle stage par"),
                        Option("b", "Sirf \$match ke baad"),
                        Option("c", "Pipeline mein kahin bhi"),
                        Option("d", "Sirf last stage par")
                    ),
                    correctOptionId = "c",
                    explanation = "\$addFields pipeline mein kahin bhi use ho sakta hai. Iska output wahi documents hain jo input mein the plus nayi fields. Ye flexibility deta hai computed fields add karne ki jo baad mein \$group, \$sort, ya doosre stages mein use ho sakti hain."
                ),
            ),
            "it_mongo_ch6_m13" to listOf(
                Question(
                    id = "ch6m13_1",
                    questionText = "\$count stage ka output kya hota hai?",
                    options = listOf(
                        Option("a", "Har document mein count field add hoti hai"),
                        Option("b", "Ek single document jisme specified field mein count hoti hai"),
                        Option("c", "Documents ki array with count property"),
                        Option("d", "Integer value directly")
                    ),
                    correctOptionId = "b",
                    explanation = "\$count: \"fieldName\" ek single document return karta hai jisme specified field mein us point tak ke documents ki count hoti hai. Jaise \$count: \"total\" → { total: 42 }."
                ),
                Question(
                    id = "ch6m13_2",
                    questionText = "Pagination implement karne ke liye stages ka correct order kya hai?",
                    options = listOf(
                        Option("a", "\$limit → \$skip → \$sort"),
                        Option("b", "\$sort → \$limit → \$skip"),
                        Option("c", "\$sort → \$skip → \$limit"),
                        Option("d", "\$skip → \$sort → \$limit")
                    ),
                    correctOptionId = "c",
                    explanation = "Pagination ke liye: \$sort → \$skip → \$limit order follow karo. Pehle sort karo consistent order ke liye, phir page start tak skip karo, phir page size tak limit karo. Page N ke liye: skip = (N-1) * pageSize."
                ),
                Question(
                    id = "ch6m13_3",
                    questionText = "\$sort mein { score: -1, name: 1 } ka kya matlab hai?",
                    options = listOf(
                        Option("a", "score descending, name ascending (tie-breaker)"),
                        Option("b", "score ascending, name descending"),
                        Option("c", "score aur name dono descending"),
                        Option("d", "score field -1 se multiply karo, name 1 se")
                    ),
                    correctOptionId = "a",
                    explanation = "\$sort mein -1 = descending (highest first), 1 = ascending (lowest/A first). Yahan score pehle descending sort hoga (primary), aur jab score same ho to name ascending se sort hoga (secondary/tie-breaker)."
                ),
            ),
            "it_mongo_ch6_m14" to listOf(
                Question(
                    id = "ch6m14_1",
                    questionText = "\$addFields ke baad us nayi field par \$sort apply karna possible hai kya?",
                    options = listOf(
                        Option("a", "Nahi, sirf existing fields par sort ho sakta hai"),
                        Option("b", "Haan, pipeline mein baad waale stages nayi fields use kar sakte hain"),
                        Option("c", "Sirf \$group ke baad sort possible hai"),
                        Option("d", "Sirf indexed fields par sort possible hai")
                    ),
                    correctOptionId = "b",
                    explanation = "Haan! Pipeline mein har stage pehle waale stage ka output use karta hai. \$addFields ke baad jo nayi fields add hui hain, unhe baad ke stages jaise \$sort, \$group, \$match mein freely use kar sakte hain."
                ),
                Question(
                    id = "ch6m14_2",
                    questionText = "Page 3 show karne ke liye (10 items per page) \$skip ki value kya hogi?",
                    options = listOf(
                        Option("a", "10"),
                        Option("b", "20"),
                        Option("c", "30"),
                        Option("d", "3")
                    ),
                    correctOptionId = "b",
                    explanation = "Page 3 ke liye skip = (3-1) * 10 = 20. Matlab pehle 20 documents skip karo (page 1 ke 10 + page 2 ke 10), phir \$limit: 10 se page 3 ke documents lo."
                ),
                Question(
                    id = "ch6m14_3",
                    questionText = "Performance ke liye pipeline mein \$match ko kahan rakhna chahiye?",
                    options = listOf(
                        Option("a", "Pipeline ke end mein"),
                        Option("b", "Pipeline ke bilkul pehle (as early as possible)"),
                        Option("c", "\$group ke baad"),
                        Option("d", "Koi fark nahi, kahan bhi rakh sakte hain")
                    ),
                    correctOptionId = "b",
                    explanation = "\$match ko pipeline mein jitna pehle ho sake rakhna chahiye. Isse baad ke stages mein kam documents process hote hain. Agar \$match indexed field par hai to MongoDB index use karta hai jo bahut fast hota hai."
                ),
            ),
            "it_mongo_ch6_m15" to listOf(
                Question(
                    id = "ch6m15_1",
                    questionText = "\$group mein \$sum: 1 ka kya matlab hai?",
                    options = listOf(
                        Option("a", "Pehla document return karo"),
                        Option("b", "Har document ke liye 1 add karo (count karo)"),
                        Option("c", "Field ki value 1 se multiply karo"),
                        Option("d", "Sirf 1 document return karo")
                    ),
                    correctOptionId = "b",
                    explanation = "\$sum: 1 har document ke liye 1 add karta hai, effectively documents count karta hai. Yeh { \$group: { _id: \"\$category\", count: { \$sum: 1 } } } mein count field mein har category ke documents ki sankhya store karta hai."
                ),
                Question(
                    id = "ch6m15_2",
                    questionText = "\$push aur \$addToSet mein kya fark hai?",
                    options = listOf(
                        Option("a", "Koi fark nahi"),
                        Option("b", "\$push sab values (with duplicates), \$addToSet sirf unique values"),
                        Option("c", "\$addToSet sab values, \$push sirf unique values"),
                        Option("d", "\$push sirf numbers ke liye, \$addToSet sirf strings ke liye")
                    ),
                    correctOptionId = "b",
                    explanation = "\$push sab values array mein add karta hai, duplicates bhi. \$addToSet sirf unique values add karta hai (Set ki tarah). Jab aapko har occurrence chahiye → \$push; unique values chahiye → \$addToSet."
                ),
                Question(
                    id = "ch6m15_3",
                    questionText = "\$group mein _id: null rakhne se kya hota hai?",
                    options = listOf(
                        Option("a", "Error aata hai"),
                        Option("b", "Null values wale documents group hote hain"),
                        Option("c", "Sab documents ek single group mein aa jaate hain"),
                        Option("d", "Koi grouping nahi hoti")
                    ),
                    correctOptionId = "c",
                    explanation = "_id: null rakhne se sab documents ek hi group mein combine ho jaate hain. Ye tab useful hai jab poori collection par aggregate karna ho — jaise total count ya grand total nikalna ho."
                ),
            ),
            "it_mongo_ch6_m16" to listOf(
                Question(
                    id = "ch6m16_1",
                    questionText = "\$bucket mein boundaries: [0, 25, 40, 100] se kitne buckets banenge?",
                    options = listOf(
                        Option("a", "4 buckets"),
                        Option("b", "3 buckets"),
                        Option("c", "2 buckets"),
                        Option("d", "5 buckets")
                    ),
                    correctOptionId = "b",
                    explanation = "N boundaries se N-1 buckets bante hain. 4 boundaries [0, 25, 40, 100] se 3 buckets: [0,25), [25,40), [40,100). Values jo 0 se kam ya 100 se zyada hain woh default bucket mein jaate hain (agar specified ho)."
                ),
                Question(
                    id = "ch6m16_2",
                    questionText = "\$bucketAuto aur \$bucket mein kya fark hai?",
                    options = listOf(
                        Option("a", "Koi fark nahi"),
                        Option("b", "\$bucketAuto boundaries khud calculate karta hai equal distribution ke liye"),
                        Option("c", "\$bucket zyada accurate hota hai"),
                        Option("d", "\$bucketAuto sirf numeric fields ke liye hai")
                    ),
                    correctOptionId = "b",
                    explanation = "\$bucket mein aap manual boundaries define karte ho. \$bucketAuto mein sirf buckets ki count batao, MongoDB khud equal distribution ke liye boundaries calculate karta hai. \$bucketAuto exploratory analysis ke liye aur \$bucket domain knowledge ke liye best hai."
                ),
                Question(
                    id = "ch6m16_3",
                    questionText = "\$bucket mein 'default' field ka kya kaam hai?",
                    options = listOf(
                        Option("a", "Default bucket naam set karta hai"),
                        Option("b", "Agar groupBy field missing ho to default value deta hai"),
                        Option("c", "Boundaries ke bahar values ke liye bucket naam specify karta hai"),
                        Option("d", "Sab buckets ka default output field define karta hai")
                    ),
                    correctOptionId = "c",
                    explanation = "\$bucket mein 'default' us bucket ka naam specify karta hai jahan woh documents jaate hain jo defined boundaries ke bahar hain (below minimum ya above maximum). Agar default nahi diya aur aise documents hain to error aata hai."
                ),
            ),
            "it_mongo_ch6_m17" to listOf(
                Question(
                    id = "ch6m17_1",
                    questionText = "\$facet stage kya return karta hai?",
                    options = listOf(
                        Option("a", "Har facet ke liye alag result set"),
                        Option("b", "Ek single document jisme har facet ek array field hai"),
                        Option("c", "Multiple collections mein results"),
                        Option("d", "Facets ki count")
                    ),
                    correctOptionId = "b",
                    explanation = "\$facet sirf ek document return karta hai. Us document mein har facet ek field hoti hai aur us field ki value us facet ke pipeline ka result (array) hoti hai. Ye sab facets ek saath ek response mein milti hain."
                ),
                Question(
                    id = "ch6m17_2",
                    questionText = "\$facet ke andar kaunsa stage use NAHI kar sakte?",
                    options = listOf(
                        Option("a", "\$group"),
                        Option("b", "\$sort"),
                        Option("c", "\$out"),
                        Option("d", "\$bucket")
                    ),
                    correctOptionId = "c",
                    explanation = "\$facet ke andar \$out stage use nahi kar sakte. Iske alawa \$facet ke andar \$facet bhi use nahi kar sakte (nesting allowed nahi). Baaki stages jaise \$group, \$sort, \$bucket, \$count \$facet ke andar use ho sakte hain."
                ),
                Question(
                    id = "ch6m17_3",
                    questionText = "\$facet ka main use case kya hai?",
                    options = listOf(
                        Option("a", "Documents delete karne ke liye"),
                        Option("b", "Ek hi data par multiple independent analyses ek saath karna"),
                        Option("c", "Pipeline ko parallel run karna performance ke liye"),
                        Option("d", "Arrays ko unwind karna")
                    ),
                    correctOptionId = "b",
                    explanation = "\$facet ka main use case hai ek hi input data par multiple independent analyses run karna ek single aggregation mein. Jaise ecommerce mein: category counts + price buckets + total count sab ek saath. Ye multiple round-trips bachata hai."
                ),
            ),
            "it_mongo_ch6_m18" to listOf(
                Question(
                    id = "ch6m18_1",
                    questionText = "\$sortByCount ka shorthand kya hai (equivalent stages)?",
                    options = listOf(
                        Option("a", "{ \$count } + { \$sort }"),
                        Option("b", "{ \$group: { _id: expr, count: { \$sum: 1 } } } + { \$sort: { count: -1 } }"),
                        Option("c", "{ \$group } + { \$count }"),
                        Option("d", "{ \$match } + { \$count }")
                    ),
                    correctOptionId = "b",
                    explanation = "\$sortByCount: expr internally { \$group: { _id: expr, count: { \$sum: 1 } } } aur phir { \$sort: { count: -1 } } karta hai. Ye dono stages ka shorthand hai — frequency analysis ke liye convenient."
                ),
                Question(
                    id = "ch6m18_2",
                    questionText = "\$sortByCount ke results kaise sort hote hain?",
                    options = listOf(
                        Option("a", "Alphabetically by _id"),
                        Option("b", "Count ascending (least common pehle)"),
                        Option("c", "Count descending (most common pehle)"),
                        Option("d", "Random order")
                    ),
                    correctOptionId = "c",
                    explanation = "\$sortByCount count ke basis par descending sort karta hai — matlab most common values pehle aate hain. Ye frequency analysis ke liye ideal hai jahan top categories ya tags dekhni hoti hain."
                ),
                Question(
                    id = "ch6m18_3",
                    questionText = "Array fields ki frequency nikalne ke liye \$sortByCount ke saath kaunsa stage combine karte hain?",
                    options = listOf(
                        Option("a", "\$group"),
                        Option("b", "\$unwind"),
                        Option("c", "\$project"),
                        Option("d", "\$addFields")
                    ),
                    correctOptionId = "b",
                    explanation = "Array fields ke elements ki frequency nikalne ke liye \$unwind pehle use karte hain (array ko individual documents mein todna), phir \$sortByCount. Jaise tags array ki frequency: \$unwind: \"\$tags\" → \$sortByCount: \"\$tags\"."
                ),
            ),
            "it_mongo_ch6_m19" to listOf(
                Question(
                    id = "ch6m19_1",
                    questionText = "\$group stage ke baad document structure mein kya bachta hai?",
                    options = listOf(
                        Option("a", "Sab original fields plus grouped fields"),
                        Option("b", "Sirf _id aur accumulator fields jo \$group mein define ki gayi"),
                        Option("c", "Sirf _id field"),
                        Option("d", "Koi fields nahi, empty document")
                    ),
                    correctOptionId = "b",
                    explanation = "\$group ke baad original document structure gone ho jaata hai. Sirf woh fields bachti hain jo \$group mein define ki gayi hain: _id (grouping key) aur koi bhi accumulator fields (\$sum, \$avg, \$push, etc.). Isliye \$project ya \$addFields baad mein use karo agar aur fields chahiye."
                ),
                Question(
                    id = "ch6m19_2",
                    questionText = "\$bucket ki boundaries kaise honi chahiye?",
                    options = listOf(
                        Option("a", "Kisi bhi order mein"),
                        Option("b", "Strictly ascending order mein"),
                        Option("c", "Descending order mein"),
                        Option("d", "Even numbers hi use ho sakte hain")
                    ),
                    correctOptionId = "b",
                    explanation = "\$bucket ki boundaries strictly ascending order mein honi chahiye. MongoDB in boundaries se intervals define karta hai: [b0, b1), [b1, b2), etc. Agar boundaries ascending order mein nahi hain to error aayega."
                ),
                Question(
                    id = "ch6m19_3",
                    questionText = "Total collection count nikalne ke liye simplest pipeline kaunsa hai?",
                    options = listOf(
                        Option("a", "{ \$group: { _id: null, total: { \$sum: 1 } } }"),
                        Option("b", "{ \$count: \"total\" }"),
                        Option("c", "A aur B dono kaam karenge"),
                        Option("d", "{ \$limit: 1 }, { \$count: \"total\" }")
                    ),
                    correctOptionId = "c",
                    explanation = "Dono kaam karte hain. \$count: \"total\" simplest hai — ek single document { total: N } return karta hai. \$group: { _id: null, total: { \$sum: 1 } } bhi same result deta hai. \$count sirf counting ke liye preferred hai simplicity ke liye."
                ),
            ),
            "it_mongo_ch6_m20" to listOf(
                Question(
                    id = "ch6m20_1",
                    questionText = "Ek document { item: \"A\", colors: [\"red\", \"blue\"] } par \$unwind: \"\$colors\" apply karne se kitne documents bante hain?",
                    options = listOf(
                        Option("a", "1 document"),
                        Option("b", "2 documents"),
                        Option("c", "3 documents"),
                        Option("d", "4 documents")
                    ),
                    correctOptionId = "b",
                    explanation = "\$unwind array ke har element ke liye ek document banata hai. colors array mein 2 elements hain (\"red\" aur \"blue\"), isliye 2 documents bante hain: { item: \"A\", colors: \"red\" } aur { item: \"A\", colors: \"blue\" }."
                ),
                Question(
                    id = "ch6m20_2",
                    questionText = "preserveNullAndEmptyArrays: true option ka kya effect hota hai?",
                    options = listOf(
                        Option("a", "Null arrays delete ho jaati hain"),
                        Option("b", "Null ya empty array wale documents bhi pipeline mein rahte hain"),
                        Option("c", "Empty arrays ko null se replace karta hai"),
                        Option("d", "Sirf null values preserve karta hai, empty arrays nahi")
                    ),
                    correctOptionId = "b",
                    explanation = "preserveNullAndEmptyArrays: true set karne se jis documents mein array field null hai ya empty [] hai, woh documents bhi pipeline mein rahte hain (normally \$unwind unhe remove kar deta hai). Ye tab useful hai jab koi bhi document miss nahi karna chahte."
                ),
                Question(
                    id = "ch6m20_3",
                    questionText = "\$unwind ke baad \$group kyun commonly use hota hai?",
                    options = listOf(
                        Option("a", "Documents count karne ke liye"),
                        Option("b", "Array elements ko phir se merge karne ke liye"),
                        Option("c", "Array ke individual elements par group-based analysis karne ke liye"),
                        Option("d", "Nested arrays handle karne ke liye")
                    ),
                    correctOptionId = "c",
                    explanation = "\$unwind array ko individual documents mein todta hai, phir \$group in individual elements par aggregate kar sakta hai. Jaise: articles mein tags array → \$unwind → \$group by tag → har tag ki article count. Ye pattern bahut common hai."
                ),
            ),
            "it_mongo_ch6_m21" to listOf(
                Question(
                    id = "ch6m21_1",
                    questionText = "\$out stage pipeline mein kahan hona chahiye?",
                    options = listOf(
                        Option("a", "Pehla stage"),
                        Option("b", "\$group ke turant baad"),
                        Option("c", "Last stage"),
                        Option("d", "Kahin bhi")
                    ),
                    correctOptionId = "c",
                    explanation = "\$out hamesha pipeline ka last stage hona chahiye. Ye pipeline ke results ko ek collection mein write karta hai aur kuch aur baad mein process nahi ho sakta. \$facet ke andar bhi \$out use nahi kar sakte."
                ),
                Question(
                    id = "ch6m21_2",
                    questionText = "\$out se output collection already exist kare to kya hoga?",
                    options = listOf(
                        Option("a", "Error aayega"),
                        Option("b", "New documents append ho jayenge"),
                        Option("c", "Puri collection atomically replace ho jaayegi"),
                        Option("d", "Sirf matching documents update honge")
                    ),
                    correctOptionId = "c",
                    explanation = "\$out existing collection ko atomically replace karta hai — puri collection pipeline results se replace ho jaati hai. Agar incremental updates chahiye to MongoDB 4.2+ ka \$merge stage use karo jo upsert, merge, ya replace options deta hai."
                ),
                Question(
                    id = "ch6m21_3",
                    questionText = "\$out mein different database mein output save karne ke liye kaunsa syntax use hota hai?",
                    options = listOf(
                        Option("a", "{ \$out: \"otherDB.collectionName\" }"),
                        Option("b", "{ \$out: { db: \"otherDB\", coll: \"collName\" } }"),
                        Option("c", "{ \$out: { database: \"otherDB\", collection: \"collName\" } }"),
                        Option("d", "{ \$out: [\"otherDB\", \"collName\"] }")
                    ),
                    correctOptionId = "b",
                    explanation = "Different database mein output ke liye object syntax: { \$out: { db: \"databaseName\", coll: \"collectionName\" } }. Simple string syntax sirf same database ke liye hai: { \$out: \"collectionName\" }."
                ),
            ),
            "it_mongo_ch6_m22" to listOf(
                Question(
                    id = "ch6m22_1",
                    questionText = "Pipeline performance ke liye sabse important best practice kya hai?",
                    options = listOf(
                        Option("a", "\$sort ko pehle stage mein rakhna"),
                        Option("b", "\$match ko jitna pehle ho sake rakhna"),
                        Option("c", "\$group ko last stage mein rakhna"),
                        Option("d", "\$limit ko pehle stage mein rakhna")
                    ),
                    correctOptionId = "b",
                    explanation = "\$match ko pipeline mein jitna pehle ho sake rakhna chahiye. Isse baad ke stages kam documents process karte hain. Indexed field par \$match aur bhi fast hota hai kyunki MongoDB index use karta hai. Ye aggregation pipeline ka most impactful optimization hai."
                ),
                Question(
                    id = "ch6m22_2",
                    questionText = "Kaunsa stage documents ki count badha sakta hai (fan-out)?",
                    options = listOf(
                        Option("a", "\$project"),
                        Option("b", "\$group"),
                        Option("c", "\$unwind"),
                        Option("d", "\$match")
                    ),
                    correctOptionId = "c",
                    explanation = "\$unwind array field ke har element ke liye ek alag document banata hai. Isliye agar ek document mein 100 elements ka array hai, \$unwind 100 documents produce karega. Ye 'fan-out' kehlata hai aur performance pe bada impact kar sakta hai."
                ),
                Question(
                    id = "ch6m22_3",
                    questionText = "ETL pipeline mein data ko final collection mein save karne ke liye kaunsa stage use karte hain?",
                    options = listOf(
                        Option("a", "\$group"),
                        Option("b", "\$addFields"),
                        Option("c", "\$out"),
                        Option("d", "\$project")
                    ),
                    correctOptionId = "c",
                    explanation = "\$out stage pipeline ke results ko ek MongoDB collection mein write karta hai. ETL (Extract, Transform, Load) workflows mein ye final 'Load' step hota hai. Ye reporting databases ya pre-computed result collections banane ke liye use hota hai."
                ),
            ),
            "it_mongo_ch3_m4" to listOf(
                Question(
                    id = "ch3mq4_1",
                    questionText = "mongodump aur mongorestore kaunsa format use karte hain?",
                    options = listOf(
                        Option("a", "JSON (readable text)"),
                        Option("b", "CSV (spreadsheet)"),
                        Option("c", "BSON (Binary JSON)"),
                        Option("d", "XML format")
                    ),
                    correctOptionId = "c",
                    explanation = "mongodump aur mongorestore BSON (Binary JSON) format use karte hain. Ye human readable nahi hota lekin speed aur performance ke liye optimized hai — isliye database transfer aur backup ke liye best hai."
                ),
                Question(
                    id = "ch3mq4_2",
                    questionText = "Pura database export karne ke liye mongodump command mein kya specify karna zaroori hai?",
                    options = listOf(
                        Option("a", "--collection aur --out dono"),
                        Option("b", "Sirf --uri kaafi hai"),
                        Option("c", "--database aur --file dono"),
                        Option("d", "--export flag")
                    ),
                    correctOptionId = "b",
                    explanation = "Pura database export karne ke liye mongodump mein sirf --uri specify karna hota hai. Collection option sirf tab chahiye jab alag se specific collection export karni ho."
                ),
                Question(
                    id = "ch3mq4_3",
                    questionText = "Kab mongodump/mongorestore use karna chahiye aur kab mongoimport/mongoexport?",
                    options = listOf(
                        Option("a", "Dono same kaam karte hain, koi fark nahi"),
                        Option("b", "mongodump sirf Windows par kaam karta hai"),
                        Option("c", "Transfer/backup ke liye BSON (mongodump), analysis ke liye JSON (mongoexport)"),
                        Option("d", "mongoimport sirf CSV files ke liye hai")
                    ),
                    correctOptionId = "c",
                    explanation = "BSON fast hota hai isliye databases ke beech transfer ya backup ke liye mongodump/mongorestore best hai. JSON human readable hota hai isliye data analyze karna ho ya text format mein kaam karna ho to mongoimport/mongoexport use karo."
                ),
            ),
            "it_mongo_ch3_m3" to listOf(
                Question(
                    id = "ch3mq3_1",
                    questionText = "mongoexport command mein --out option ka kya kaam hai?",
                    options = listOf(
                        Option("a", "Output database ka naam specify karta hai"),
                        Option("b", "Ye batata hai ki exported file kahan save hogi"),
                        Option("c", "Output format (JSON/CSV) specify karta hai"),
                        Option("d", "Cluster ka URI specify karta hai")
                    ),
                    correctOptionId = "b",
                    explanation = "--out option mein tum output file ka naam aur path specify karte ho jahan exported JSON file save hogi. Jaise: --out=import_export_col1.json"
                ),
                Question(
                    id = "ch3mq3_2",
                    questionText = "URI mein 'mongodb+srv://' ka kya matlab hai?",
                    options = listOf(
                        Option("a", "Ye MongoDB ka version number hai"),
                        Option("b", "Ye ek secure connection indicate karta hai"),
                        Option("c", "Ye database ka naam hai"),
                        Option("d", "Ye cluster ki region hai")
                    ),
                    correctOptionId = "b",
                    explanation = "mongodb+srv:// URI ka pehla part hai jo secure connection indicate karta hai. Uske baad username:password@cluster-url/database aata hai."
                ),
                Question(
                    id = "ch3mq3_3",
                    questionText = "mongoimport command mein collection delete karke phir import karne ka result kya hoga?",
                    options = listOf(
                        Option("a", "Error aayega — deleted collection restore nahi hoti"),
                        Option("b", "Collection nayi ban jaayegi aur JSON file ka data us mein aa jaayega"),
                        Option("c", "Data automatically duplicate ho jaayega"),
                        Option("d", "Compass automatically refresh ho jaayega")
                    ),
                    correctOptionId = "b",
                    explanation = "mongoimport collection delete hone ke baad bhi kaam karta hai — collection dobara ban jaati hai aur JSON file ka saara data us mein import ho jaata hai. Compass mein refresh karne par data dikhne lagta hai."
                ),
            ),
            "it_mongo_ch3_m2" to listOf(
                Question(
                    id = "ch3mq2_1",
                    questionText = "Compass mein collection export karne ke liye kaunsa format choose kar sakte hain?",
                    options = listOf(
                        Option("a", "Sirf JSON"),
                        Option("b", "Sirf CSV"),
                        Option("c", "JSON ya CSV dono"),
                        Option("d", "BSON ya XML")
                    ),
                    correctOptionId = "c",
                    explanation = "Compass mein Export Collection karte waqt tum JSON ya CSV dono mein se koi bhi format choose kar sakte ho. JSON document structure preserve karta hai jabki CSV spreadsheet format mein hota hai."
                ),
                Question(
                    id = "ch3mq2_2",
                    questionText = "Compass mein import ke waqt _id field kahan se aati hai?",
                    options = listOf(
                        Option("a", "User manually enter karta hai"),
                        Option("b", "MongoDB automatically har document ko _id assign karta hai"),
                        Option("c", "JSON file mein pehle se hoti hai aur change nahi hoti"),
                        Option("d", "Atlas dashboard se generate hoti hai")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB automatically har document ko ek unique _id field assign karta hai. Agar JSON file mein _id nahi hai to MongoDB naya generate kar deta hai, agar hai to wahi use karta hai."
                ),
                Question(
                    id = "ch3mq2_3",
                    questionText = "Compass mein collection import karne ke liye pehle kya karna hota hai?",
                    options = listOf(
                        Option("a", "Atlas mein login karna"),
                        Option("b", "Terminal open karna"),
                        Option("c", "Pehle ek collection create karni hoti hai, phir Add Data → Import File"),
                        Option("d", "JSON file ko BSON mein convert karna")
                    ),
                    correctOptionId = "c",
                    explanation = "Compass mein import karne ke liye pehle plus icon se ek collection create karni hoti hai, phir collection open karke Add Data → Import File select karo aur apni JSON file browse karke import karo."
                ),
            ),
            "it_mongo_ch3_m1" to listOf(
                Question(
                    id = "ch3mq1_1",
                    questionText = "Mac terminal mein current directory print karne ka command kya hai?",
                    options = listOf(
                        Option("a", "dir"),
                        Option("b", "ls"),
                        Option("c", "cd"),
                        Option("d", "pwd")
                    ),
                    correctOptionId = "d",
                    explanation = "pwd (Print Working Directory) Mac terminal mein current directory ka path dikhata hai. Windows mein iske liye cd (bina argument ke) use karte hain."
                ),
                Question(
                    id = "ch3mq1_2",
                    questionText = "Ek level upar (parent folder mein) jaane ke liye kaunsa command use karte hain?",
                    options = listOf(
                        Option("a", "cd up"),
                        Option("b", "cd back"),
                        Option("c", "cd .."),
                        Option("d", "cd /")
                    ),
                    correctOptionId = "c",
                    explanation = "cd .. (do dots) current directory se ek level upar parent folder mein le jaata hai. Ye Mac aur Windows dono mein same kaam karta hai."
                ),
                Question(
                    id = "ch3mq1_3",
                    questionText = "Desktop se directly 2 levels neeche sub_folder_1 mein jaana ho to kya karna padega?",
                    options = listOf(
                        Option("a", "cd sub_folder_1 — seedha kaam ho jaata hai"),
                        Option("b", "cd Desktop/sub_folder_1 — shortcut se"),
                        Option("c", "Seedha nahi jaate — pehle cd top_folder, phir cd sub_folder_1"),
                        Option("d", "cd .. se neeche jaate hain")
                    ),
                    correctOptionId = "c",
                    explanation = "Terminal mein ek baar mein sirf ek level move kar sakte ho. Do levels neeche jaane ke liye step by step karna padta hai: pehle cd top_folder, phir cd sub_folder_1."
                ),
            ),
            "it_mongo_ch2_m7" to listOf(
                Question(
                    id = "ch2mq7_1",
                    questionText = "Terminal mein mongosh se disconnect karne ke liye kaunsa command use karte hain?",
                    options = listOf(
                        Option("a", "quit"),
                        Option("b", "disconnect"),
                        Option("c", "exit"),
                        Option("d", "logout")
                    ),
                    correctOptionId = "c",
                    explanation = "Terminal mein 'exit' type karne se tum MongoDB instance se disconnect ho jaate ho. Ya phir terminal/CMD window band kar do — tab bhi disconnect ho jaata hai."
                ),
                Question(
                    id = "ch2mq7_2",
                    questionText = "mongosh connect hone ke baad apne saare databases dekhne ke liye kaunsa command use karte hain?",
                    options = listOf(
                        Option("a", "list databases"),
                        Option("b", "show dbs"),
                        Option("c", "get databases"),
                        Option("d", "view dbs")
                    ),
                    correctOptionId = "b",
                    explanation = "'show dbs' command MongoDB Shell mein saare available databases ki list dikhata hai — jisme humara sample_training database bhi hoga."
                ),
                Question(
                    id = "ch2mq7_3",
                    questionText = "mongoimport aur mongoexport tools kiske saath directly connect hote hain?",
                    options = listOf(
                        Option("a", "Sirf Compass ke saath"),
                        Option("b", "Sirf Atlas Dashboard ke saath"),
                        Option("c", "Terminal ya Command Prompt ke saath"),
                        Option("d", "Browser ke saath")
                    ),
                    correctOptionId = "c",
                    explanation = "MongoDB Database Tools (mongoimport, mongoexport) directly Terminal ya Command Prompt ke saath connect hote hain aur data import/export karne ke kaam aate hain."
                ),
            ),
            "it_mongo_ch2_m6" to listOf(
                Question(
                    id = "ch2mq6_1",
                    questionText = "Atlas ke top menu mein 'Charts' ka kya kaam hai?",
                    options = listOf(
                        Option("a", "Applications develop karna"),
                        Option("b", "MongoDB mein stored data ko visually dikhana (graphs, dashboards)"),
                        Option("c", "Cluster backup lena"),
                        Option("d", "Users create karna")
                    ),
                    correctOptionId = "b",
                    explanation = "Charts MongoDB mein stored data ko visually represent karta hai — graphs, pie charts aur dashboards ke through. Realm application development ke liye hota hai, Charts data visualization ke liye."
                ),
                Question(
                    id = "ch2mq6_2",
                    questionText = "Free tier MongoDB Atlas cluster mein kitne nodes hote hain?",
                    options = listOf(
                        Option("a", "1"),
                        Option("b", "2"),
                        Option("c", "3"),
                        Option("d", "5")
                    ),
                    correctOptionId = "c",
                    explanation = "Free tier cluster ek Replica Set hota hai jisme 3 nodes hote hain — 3 alag machines par data replicate hota hai. Isse high availability milti hai."
                ),
                Question(
                    id = "ch2mq6_3",
                    questionText = "Atlas mein Network Access section ka kya kaam hai?",
                    options = listOf(
                        Option("a", "Database users create karna"),
                        Option("b", "Cluster ka backup lena"),
                        Option("c", "IP addresses allow karna jo cluster ko access kar sakein"),
                        Option("d", "Collections delete karna")
                    ),
                    correctOptionId = "c",
                    explanation = "Network Access section mein IP addresses whitelist kiye jaate hain. Training ke liye 0.0.0.0/0 set karte hain (kahi se bhi access), lekin production mein hamesha specific IPs whitelist karni chahiye."
                ),
            ),
            "it_mongo_ch2_m5" to listOf(
                Question(
                    id = "ch2mq5_1",
                    questionText = "Atlas connect hone ke baad jo 3 system databases dikhte hain, unke baare mein kya sahi hai?",
                    options = listOf(
                        Option("a", "Inhe delete kar sakte hain — koi fark nahi padta"),
                        Option("b", "Ye MongoDB ke system-generated databases hain, inhe delete nahi karna chahiye"),
                        Option("c", "Ye sample data databases hain jo humne create kiye hain"),
                        Option("d", "Ye sirf Mac par dikhte hain, Windows par nahi")
                    ),
                    correctOptionId = "b",
                    explanation = "admin, config aur local — ye teen MongoDB ke internal system databases hain jo automatically create hote hain. Inhe delete karne se cluster ka kaam bigad sakta hai, isliye inhe kabhi delete nahi karna chahiye."
                ),
                Question(
                    id = "ch2mq5_2",
                    questionText = "sample_training database mein kitni JSON files import karni hoti hain?",
                    options = listOf(
                        Option("a", "3"),
                        Option("b", "5"),
                        Option("c", "7"),
                        Option("d", "10")
                    ),
                    correctOptionId = "c",
                    explanation = "Resources section se download ki gayi ZIP file mein 7 JSON files hoti hain — companies, grades, inspections, routes, trips, zips aur ek aur. Inhe unke same naam ki collections mein import karte hain."
                ),
                Question(
                    id = "ch2mq5_3",
                    questionText = "Is course mein MongoDB operations ke liye mainly kaunsa tool use kiya jaayega?",
                    options = listOf(
                        Option("a", "Sirf Compass GUI"),
                        Option("b", "Atlas Dashboard"),
                        Option("c", "Terminal / CMD ke through mongosh (Mongo Shell)"),
                        Option("d", "VS Code extension")
                    ),
                    correctOptionId = "c",
                    explanation = "Compass mein bhi mongosh dikhta hai, lekin is course mein mainly Terminal ya Command Prompt ke through mongosh use karenge — kyunki wahan zyada operations perform kar sakte hain."
                ),
            ),
            "it_mongo_ch2_m4" to listOf(
                Question(
                    id = "ch2mq4_1",
                    questionText = "MongoDB Compass kya hai?",
                    options = listOf(
                        Option("a", "Ek terminal-based query tool hai"),
                        Option("b", "Ek command line installer hai"),
                        Option("c", "Ek graphical interface (GUI) tool hai jisse database visually dekh sakte hain"),
                        Option("d", "Ek cloud backup service hai")
                    ),
                    correctOptionId = "c",
                    explanation = "MongoDB Compass ek GUI tool hai jo tumhe database, collections, aur documents visually dekhne aur manage karne ki suvidha deta hai — bina terminal ke. Beginners ke liye bahut helpful hai!"
                ),
                Question(
                    id = "ch2mq4_2",
                    questionText = "Windows par Compass install karne ke liye kaunsa package download karna chahiye?",
                    options = listOf(
                        Option("a", "ZIP package"),
                        Option("b", "TAR package"),
                        Option("c", "EXE package"),
                        Option("d", "MSI package")
                    ),
                    correctOptionId = "d",
                    explanation = "Windows par MongoDB Compass install karne ke liye MSI package download karna hota hai, ZIP nahi. MSI ek proper Windows installer hai jo automatically setup kar deta hai."
                ),
                Question(
                    id = "ch2mq4_3",
                    questionText = "Compass ko Atlas cluster se connect karne ke liye kya use karte hain?",
                    options = listOf(
                        Option("a", "Cluster ka naam type karte hain"),
                        Option("b", "Atlas dashboard se connection string copy karke Compass mein paste karte hain"),
                        Option("c", "Email aur password directly enter karte hain"),
                        Option("d", "SSH key use karte hain")
                    ),
                    correctOptionId = "b",
                    explanation = "Atlas dashboard mein cluster ke 'Connect' button se 'Connect using MongoDB Compass' option milta hai. Wahan se connection string (mongodb+srv://...) copy karke Compass mein paste karte hain."
                ),
            ),
            "it_mongo_ch2_m3" to listOf(
                Question(
                    id = "ch2mq3_1",
                    questionText = "Mongo Shell install hone ke baad test karne ke liye kaunsa command use karte hain?",
                    options = listOf(
                        Option("a", "mongosh --version"),
                        Option("b", "mongosh --start"),
                        Option("c", "mongosh --test"),
                        Option("d", "mongosh --help")
                    ),
                    correctOptionId = "d",
                    explanation = "mongosh --help command run karne par agar output aata hai to iska matlab installation successful hai. Yahi command Database Tools ke liye bhi use hoti hai (mongoexport --help)."
                ),
                Question(
                    id = "ch2mq3_2",
                    questionText = "Mac OS par executable files ko kahan copy karna hota hai?",
                    options = listOf(
                        Option("a", "Desktop par"),
                        Option("b", "Downloads folder mein"),
                        Option("c", "/usr/local/bin folder mein"),
                        Option("d", "Documents folder mein")
                    ),
                    correctOptionId = "c",
                    explanation = "/usr/local/bin ek system folder hai jo PATH variable mein already listed hota hai. Yahan copy karne se terminal directly in executables ko dhundh leta hai."
                ),
                Question(
                    id = "ch2mq3_3",
                    questionText = "Windows par PATH variable mein path add karne ka kya faayda hai?",
                    options = listOf(
                        Option("a", "File automatically delete ho jaati hai"),
                        Option("b", "File compress ho jaati hai"),
                        Option("c", "Windows CMD se executable files ko seedha run kar sakta hai"),
                        Option("d", "File automatically update hoti rehti hai")
                    ),
                    correctOptionId = "c",
                    explanation = "PATH variable Windows ko batata hai ki executable files kahan hain. Iske baad tum CMD mein kahi se bhi mongosh ya mongoexport directly type karke run kar sakte ho."
                ),
            ),
            "it_mongo_ch2_m2" to listOf(
                Question(
                    id = "ch2mq2_1",
                    questionText = "Atlas cluster setup mein 'M0' tier ka kya matlab hai?",
                    options = listOf(
                        Option("a", "MongoDB version 0"),
                        Option("b", "Free shared cluster — 512MB storage, no credit card needed"),
                        Option("c", "Managed enterprise tier"),
                        Option("d", "Minimum 0 users cluster")
                    ),
                    correctOptionId = "b",
                    explanation = "M0 Atlas ka free tier hai jisme 512MB storage milti hai aur credit card ki zaroorat nahi. Practice aur learning ke liye bilkul perfect. M10 aur above paid dedicated tiers hain production use ke liye."
                ),
                Question(
                    id = "ch2mq2_2",
                    questionText = "Atlas cluster banate waqt 'IP Access List' mein '0.0.0.0/0' kyun add karte hain?",
                    options = listOf(
                        Option("a", "Security badhaane ke liye"),
                        Option("b", "Learning ke liye — kisi bhi IP se connection allow karne ke liye"),
                        Option("c", "Cluster ko public internet pe share karne ke liye"),
                        Option("d", "Free tier activate karne ke liye")
                    ),
                    correctOptionId = "b",
                    explanation = "0.0.0.0/0 matlab 'sab IP addresses ko allow karo'. Learning mein ye convenient hai kyunki apna IP change hota rehta hai. Production mein ye KABHI nahi karna chahiye — sirf specific IPs allow karo. Learning purpose ke liye short-term use ke liye OK hai."
                ),
                Question(
                    id = "ch2mq2_3",
                    questionText = "Atlas connection string (URI) mein 'myuser:mypassword@' ka kya role hai?",
                    options = listOf(
                        Option("a", "Database ka naam specify karna"),
                        Option("b", "Cluster ki location batana"),
                        Option("c", "Authentication — username aur password se verify karna ki aap authorized user ho"),
                        Option("d", "Network port specify karna")
                    ),
                    correctOptionId = "c",
                    explanation = "Connection string ka format hota hai: mongodb+srv://username:password@cluster-address/. Username aur password Atlas mein banaye gaye database user ke credentials hain — ye verify karta hai ki connection authorized hai. Kabhi bhi apna password public code mein expose mat karo."
                ),
            ),
            "it_mongo_ch2_m1" to listOf(
                Question(
                    id = "ch2mq1_1",
                    questionText = "MQL ka full form kya hai?",
                    options = listOf(
                        Option("a", "Machine Query Logic"),
                        Option("b", "MongoDB Query Language"),
                        Option("c", "Multiple Query List"),
                        Option("d", "Managed Query Layer")
                    ),
                    correctOptionId = "b",
                    explanation = "MQL ka full form MongoDB Query Language hai. Ye wo language hai jisme hum MongoDB se data dhundh sakte hain, add kar sakte hain, update kar sakte hain aur delete kar sakte hain. Jaise SQL tha relational databases ke liye, MQL hai MongoDB ke liye."
                ),
                Question(
                    id = "ch2mq1_2",
                    questionText = "find() command MongoDB mein kya karta hai?",
                    options = listOf(
                        Option("a", "Naye documents insert karta hai"),
                        Option("b", "Documents delete karta hai"),
                        Option("c", "Collection se matching documents retrieve karta hai"),
                        Option("d", "Database create karta hai")
                    ),
                    correctOptionId = "c",
                    explanation = "find() command collection mein se documents retrieve karne ke liye use hota hai. Agar koi filter nahi diya toh saare documents aate hain. Filter dene par sirf matching documents aate hain — jaise db.students.find({grade: 'A'}) se sirf grade A wale students aayenge."
                ),
                Question(
                    id = "ch2mq1_3",
                    questionText = "db.collection.insertOne() aur db.collection.insertMany() mein kya fark hai?",
                    options = listOf(
                        Option("a", "Koi fark nahi — dono same kaam karte hain"),
                        Option("b", "insertOne() ek document insert karta hai; insertMany() ek saath kai documents insert karta hai"),
                        Option("c", "insertMany() sirf strings insert kar sakta hai"),
                        Option("d", "insertOne() paid feature hai")
                    ),
                    correctOptionId = "b",
                    explanation = "insertOne() ek single document insert karta hai: db.students.insertOne({name: 'Rahul', grade: 10}). insertMany() ek array of documents ek hi operation mein insert karta hai. Bulk insert ke liye insertMany() zyada efficient hai."
                ),
            ),
            "it_mongo_ch1_m6" to listOf(
                Question(
                    id = "ch1mq6_1",
                    questionText = "Horizontal scaling (Sharding) ka kya matlab hai MongoDB mein?",
                    options = listOf(
                        Option("a", "Ek hi server ka RAM aur CPU badhana"),
                        Option("b", "Data ko multiple servers pe distribute karna taaki load share ho sake"),
                        Option("c", "Database backup banana"),
                        Option("d", "Queries optimize karna")
                    ),
                    correctOptionId = "b",
                    explanation = "Horizontal scaling (ya sharding) mein data ko multiple servers (shards) mein divide kiya jaata hai. Jaise 1 crore documents hain toh 3 servers pe 33 lakh each. Ye SQL ke vertical scaling (ek hi machine ka hardware upgrade) se zyada cost-effective hai large scale pe."
                ),
                Question(
                    id = "ch1mq6_2",
                    questionText = "MongoDB ka flexible schema SQL pe kab advantage deta hai?",
                    options = listOf(
                        Option("a", "Jab data bilkul same structure ka ho"),
                        Option("b", "Jab application requirements frequently change hoti hain aur evolving data structures chahiye"),
                        Option("c", "Sirf financial applications mein"),
                        Option("d", "Jab data 100MB se kam ho")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB ka flexible schema tab sabse useful hai jab requirements change hoti rahti hain. Naya field add karna hai? Bas document mein add karo — existing documents ko change nahi karna padta. SQL mein ALTER TABLE command se poore table ka structure change karna padta hai jo production mein risky hota hai."
                ),
                Question(
                    id = "ch1mq6_3",
                    questionText = "MongoDB Atlas free tier (M0) ke baare mein kya sach hai?",
                    options = listOf(
                        Option("a", "Sirf 7 din ke liye free hai"),
                        Option("b", "512MB storage ke saath permanently free hai — practice ke liye perfect"),
                        Option("c", "Free mein sirf read operations allowed hain"),
                        Option("d", "Free tier mein connections ki koi limit nahi")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB Atlas M0 tier permanently free hai jisme 512MB storage milti hai. Ye tier hum jaisi learners ke liye perfect hai — pura course is free tier pe complete kar sakte ho. Production ke liye paid tiers hain (M10 aur above) lekin learning ke liye M0 bilkul sufficient hai."
                ),
            ),
            "it_mongo_ch1_m5" to listOf(
                Question(
                    id = "ch1mq5_1",
                    questionText = "Replica Set mein 'Primary' node ka kya kaam hai?",
                    options = listOf(
                        Option("a", "Sirf backup rakhna"),
                        Option("b", "Sabhi read aur write operations handle karna"),
                        Option("c", "Network manage karna"),
                        Option("d", "Data compress karna")
                    ),
                    correctOptionId = "b",
                    explanation = "Primary node wo main server hai jahan se actual read aur write operations hote hain. Clients Primary se baat karte hain. Secondary nodes Primary ka data copy karte rehte hain. Agar Primary fail ho, ek Secondary automatically Primary ban jaata hai — ye automatic failover hai."
                ),
                Question(
                    id = "ch1mq5_2",
                    questionText = "Replica Set mein minimum kitne members hone chahiye aur kyun?",
                    options = listOf(
                        Option("a", "1 member — sirf Primary kaafi hai"),
                        Option("b", "2 members — Primary aur ek Secondary"),
                        Option("c", "3 members — voting ke liye odd number zaroori hai"),
                        Option("d", "5 members — maximum performance ke liye")
                    ),
                    correctOptionId = "c",
                    explanation = "3 members recommended hain kyunki jab Primary fail hota hai tab naye Primary ka election hota hai. Election mein majority votes chahiye. 2 nodes mein agar ek fail ho to majority possible nahi — system stuck ho jaata. 3 nodes mein 2 votes = majority, toh election ho sakta hai."
                ),
                Question(
                    id = "ch1mq5_3",
                    questionText = "'Automatic Failover' Replica Set mein kya karta hai?",
                    options = listOf(
                        Option("a", "Data automatically backup server pe copy ho jaata hai"),
                        Option("b", "Agar Primary fail ho, ek Secondary automatically naya Primary ban jaata hai"),
                        Option("c", "Failed server automatically restart ho jaata hai"),
                        Option("d", "User ko manually naya server select karna padta hai")
                    ),
                    correctOptionId = "b",
                    explanation = "Automatic Failover ka matlab hai ki agar Primary server crash ho jaaye, toh remaining Secondary nodes election karte hain aur ek new Primary choose hota hai — automatically, bina human intervention ke. Ye process usually seconds mein complete ho jaati hai, isliye application ka downtime almost zero hota hai."
                ),
            ),
            "it_mongo_ch1_m4" to listOf(
                Question(
                    id = "ch1mq4_1",
                    questionText = "MongoDB Compass kya hai?",
                    options = listOf(
                        Option("a", "MongoDB ka command-line shell"),
                        Option("b", "Cloud database hosting service"),
                        Option("c", "GUI tool jo data visually browse aur query karne deta hai"),
                        Option("d", "MongoDB ka backup tool")
                    ),
                    correctOptionId = "c",
                    explanation = "MongoDB Compass ek Graphical User Interface (GUI) tool hai. Isse aap apna data visually dekh sakte ho, documents add/edit/delete kar sakte ho, aur queries run kar sakte ho — bina terminal use kiye. Beginners ke liye bahut helpful tool hai."
                ),
                Question(
                    id = "ch1mq4_2",
                    questionText = "MongoDB Atlas kya provide karta hai?",
                    options = listOf(
                        Option("a", "Local development environment sirf"),
                        Option("b", "Cloud-hosted MongoDB database service with free tier"),
                        Option("c", "MongoDB ka paid GUI tool"),
                        Option("d", "Sirf backup aur restore functionality")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB Atlas ek fully managed cloud database service hai. Iska free tier (M0) available hai jis par hum practice kar sakte hain. Atlas installation, maintenance, aur scaling sab manage karta hai — aapko sirf apna application develop karna hai."
                ),
                Question(
                    id = "ch1mq4_3",
                    questionText = "mongosh kya hai aur kab use hota hai?",
                    options = listOf(
                        Option("a", "Ek GUI dashboard for viewing data"),
                        Option("b", "MongoDB ka official command-line shell — terminal se queries run karne ke liye"),
                        Option("c", "MongoDB ko install karne ka tool"),
                        Option("d", "Sirf Windows ke liye available tool")
                    ),
                    correctOptionId = "b",
                    explanation = "mongosh (MongoDB Shell) ek interactive command-line interface hai. Isse aap terminal mein seedha MongoDB queries likh sakte ho — find, insert, update, delete sab. Professional developers daily mongosh use karte hain. Compass visual hai, mongosh programmatic."
                ),
            ),
            "it_mongo_ch1_m3" to listOf(
                Question(
                    id = "ch1mq3_1",
                    questionText = "MongoDB document mein '_id' field ka kya role hai?",
                    options = listOf(
                        Option("a", "Document ka title store karna"),
                        Option("b", "Har document ka unique identifier — automatically generate hota hai"),
                        Option("c", "Document ka size batana"),
                        Option("d", "Collection ka naam store karna")
                    ),
                    correctOptionId = "b",
                    explanation = "_id field MongoDB mein primary key ki tarah kaam karta hai. Agar aap khud nahi dete, MongoDB automatically ek ObjectId generate karta hai jo globally unique hota hai. Koi bhi do documents mein same _id nahi ho sakta."
                ),
                Question(
                    id = "ch1mq3_2",
                    questionText = "SQL ke rows aur columns ke comparison mein, MongoDB documents ka kya advantage hai?",
                    options = listOf(
                        Option("a", "Documents sirf numbers store kar sakte hain"),
                        Option("b", "Documents mein nested objects aur arrays bhi store ho sakte hain — flexible structure"),
                        Option("c", "Documents SQL se slower hain"),
                        Option("d", "Documents mein sirf 10 fields ho sakti hain")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB documents ka sabse bada advantage unki flexibility hai. Ek document mein nested objects (jaise address ka pura detail) aur arrays (jaise multiple phone numbers) store ho sakte hain. SQL mein ye sab alag tables mein store karna padta aur JOIN lagana padta."
                ),
                Question(
                    id = "ch1mq3_3",
                    questionText = "MongoDB mein 'schema-less' ka kya matlab hai?",
                    options = listOf(
                        Option("a", "MongoDB mein koi bhi data store nahi ho sakta"),
                        Option("b", "Har collection mein same structure ke documents hone zaroori nahi"),
                        Option("c", "MongoDB automatically schema create karta hai"),
                        Option("d", "Schema sirf paid version mein available hai")
                    ),
                    correctOptionId = "b",
                    explanation = "Schema-less matlab hai ki MongoDB collection mein alag-alag structure ke documents ho sakte hain. Ek student document mein 'grade' field ho sakti hai jabki doosre mein nahi — ye allowed hai. SQL mein har row ka structure same hona zaroori hai."
                ),
            ),
            "it_mongo_ch1_m2" to listOf(
                Question(
                    id = "ch1mq2_1",
                    questionText = "MongoDB mein 'Collection' kya hota hai?",
                    options = listOf(
                        Option("a", "Ek single row of data"),
                        Option("b", "Related documents ka ek group — jaise ek folder mein files"),
                        Option("c", "Ek database ka naam"),
                        Option("d", "Ek column ka naam")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB mein Collection ek set of related documents hoti hai — bilkul SQL ki table ki tarah, par bina fixed schema ke. Jaise ek 'students' collection mein saare student documents honge."
                ),
                Question(
                    id = "ch1mq2_2",
                    questionText = "MongoDB document kis format mein store hota hai?",
                    options = listOf(
                        Option("a", "XML format"),
                        Option("b", "Plain text"),
                        Option("c", "BSON (Binary JSON)"),
                        Option("d", "CSV format")
                    ),
                    correctOptionId = "c",
                    explanation = "MongoDB documents internally BSON (Binary JSON) format mein store hote hain. BSON, JSON ka binary representation hai — isme extra data types hote hain jaise Date aur binary data. Hum unhe JSON ki tarah likhte hain lekin storage BSON mein hoti hai."
                ),
                Question(
                    id = "ch1mq2_3",
                    questionText = "Is hierarchy mein kya sahi order hai? (Sabse bada to sabse chhota)",
                    options = listOf(
                        Option("a", "Document to Collection to Database"),
                        Option("b", "Collection to Database to Document"),
                        Option("c", "Database to Collection to Document"),
                        Option("d", "Database to Document to Collection")
                    ),
                    correctOptionId = "c",
                    explanation = "Sahi order hai: Database (sabse bada container) to Collection (documents ka group) to Document (actual data). Jaise: almirah (database) to drawer (collection) to form/card (document)."
                ),
            ),
            "it_mongo_ch1_m1" to listOf(
                Question(
                    id = "ch1mq1_1",
                    questionText = "NoSQL database SQL database se kaise alag hota hai?",
                    options = listOf(
                        Option("a", "NoSQL sirf numbers store karta hai"),
                        Option("b", "NoSQL tables use nahi karta — data alag formats mein store hota hai jaise documents"),
                        Option("c", "NoSQL sirf cloud par kaam karta hai"),
                        Option("d", "NoSQL mein data store nahi hota")
                    ),
                    correctOptionId = "b",
                    explanation = "NoSQL databases (jaise MongoDB) data ko tables mein nahi, balki documents, key-value pairs, ya graphs mein store karte hain. SQL relational model use karta hai jisme tables aur predefined relationships hoti hain."
                ),
                Question(
                    id = "ch1mq1_2",
                    questionText = "Is course mein hum primarily kaunse type ka NoSQL database seekhenge?",
                    options = listOf(
                        Option("a", "Key-Value Database"),
                        Option("b", "Graph Database"),
                        Option("c", "Wide Column Database"),
                        Option("d", "Document Database (MongoDB)")
                    ),
                    correctOptionId = "d",
                    explanation = "Is course mein hum Document Database — specifically MongoDB — seekhenge. MongoDB mein data JSON-jaisi documents mein store hota hai. Key-Value, Graph, aur Wide Column bhi NoSQL ke types hain lekin is course ka focus nahi hain."
                ),
                Question(
                    id = "ch1mq1_3",
                    questionText = "SQL database mein alag tables kyun use hoti hain?",
                    options = listOf(
                        Option("a", "Isliye ki tables dikhne mein sundar lagti hain"),
                        Option("b", "Isliye ki data redundancy avoid ho sake aur linked information alag rakhi jaye"),
                        Option("c", "Isliye ki database faster ho jaaye"),
                        Option("d", "SQL sirf ek table support karta hai")
                    ),
                    correctOptionId = "b",
                    explanation = "SQL relational model mein data alag tables mein rakha jaata hai taaki same information baar baar repeat na ho (no redundancy). Tables common fields ke through linked hoti hain. Ek query ke liye in tables ko JOIN karke data laaya jaata hai."
                ),
            ),
            "c6_ch1_m1" to listOf(
                Question(
                    id = "q1",
                    questionText = "Which of the following is NOT a natural number?",
                    options = listOf(
                        Option("a", "1"), Option("b", "5"), Option("c", "0"), Option("d", "100")
                    ),
                    correctOptionId = "c",
                    explanation = "0 is a whole number but not a natural number. Natural numbers start from 1."
                ),
                Question(
                    id = "q2",
                    questionText = "The smallest natural number is:",
                    options = listOf(
                        Option("a", "0"), Option("b", "1"), Option("c", "-1"), Option("d", "10")
                    ),
                    correctOptionId = "b",
                    explanation = "Natural numbers start from 1. So the smallest natural number is 1."
                ),
                Question(
                    id = "q3",
                    questionText = "Which of the following is a whole number but not a natural number?",
                    options = listOf(
                        Option("a", "3"), Option("b", "7"), Option("c", "0"), Option("d", "15")
                    ),
                    correctOptionId = "c",
                    explanation = "0 is the only whole number that is not a natural number."
                ),
            ),
            "c6_ch1_m2" to listOf(
                Question(
                    id = "q1",
                    questionText = "In the number 6,789, the place value of 7 is:",
                    options = listOf(
                        Option("a", "7"), Option("b", "70"), Option("c", "700"), Option("d", "7000")
                    ),
                    correctOptionId = "c",
                    explanation = "7 is in the hundreds place, so its place value is 700."
                ),
                Question(
                    id = "q2",
                    questionText = "The expanded form of 4,052 is:",
                    options = listOf(
                        Option("a", "4000 + 52"),
                        Option("b", "4000 + 50 + 2"),
                        Option("c", "4000 + 100 + 52"),
                        Option("d", "4000 + 0 + 50 + 2"),
                    ),
                    correctOptionId = "d",
                    explanation = "4,052 = 4,000 + 0 (hundreds) + 50 + 2. Option (d) shows the full expanded form."
                ),
                Question(
                    id = "q3",
                    questionText = "In the Indian number system, 1 lakh is equal to:",
                    options = listOf(
                        Option("a", "10,000"),
                        Option("b", "1,00,000"),
                        Option("c", "10,00,000"),
                        Option("d", "1,000"),
                    ),
                    correctOptionId = "b",
                    explanation = "1 lakh = 1,00,000 (one hundred thousand in the international system)."
                ),
            ),
            "c6_ch2_m1" to listOf(
                Question(
                    id = "q1",
                    questionText = "In the fraction 5/8, what is the denominator?",
                    options = listOf(
                        Option("a", "5"), Option("b", "8"), Option("c", "3"), Option("d", "13")
                    ),
                    correctOptionId = "b",
                    explanation = "The denominator is the bottom number in a fraction. In 5/8, the denominator is 8."
                ),
                Question(
                    id = "q2",
                    questionText = "If a cake is divided into 6 equal pieces and you eat 2, what fraction did you eat?",
                    options = listOf(
                        Option("a", "2/4"), Option("b", "6/2"), Option("c", "2/6"), Option("d", "2/8")
                    ),
                    correctOptionId = "c",
                    explanation = "You ate 2 pieces out of 6 equal parts, so the fraction is 2/6."
                ),
                Question(
                    id = "q3",
                    questionText = "Can a fraction have 0 as its denominator?",
                    options = listOf(
                        Option("a", "Yes, always"),
                        Option("b", "Yes, sometimes"),
                        Option("c", "No, never"),
                        Option("d", "Only for whole numbers"),
                    ),
                    correctOptionId = "c",
                    explanation = "A fraction can never have 0 as its denominator because division by 0 is undefined."
                ),
            ),
            "c6_ch2_m2" to listOf(
                Question(
                    id = "q1",
                    questionText = "Which of the following is a proper fraction?",
                    options = listOf(
                        Option("a", "5/3"), Option("b", "7/7"), Option("c", "3/4"), Option("d", "9/2")
                    ),
                    correctOptionId = "c",
                    explanation = "In a proper fraction, the numerator is less than the denominator. 3 < 4, so 3/4 is proper."
                ),
                Question(
                    id = "q2",
                    questionText = "The mixed fraction form of 11/4 is:",
                    options = listOf(
                        Option("a", "2¾"), Option("b", "3¼"), Option("c", "2¼"), Option("d", "1¾")
                    ),
                    correctOptionId = "a",
                    explanation = "11 ÷ 4 = 2 remainder 3, so 11/4 = 2¾."
                ),
                Question(
                    id = "q3",
                    questionText = "Which pair are like fractions?",
                    options = listOf(
                        Option("a", "1/3 and 2/5"),
                        Option("b", "2/7 and 5/7"),
                        Option("c", "3/4 and 3/5"),
                        Option("d", "1/2 and 2/1"),
                    ),
                    correctOptionId = "b",
                    explanation = "Like fractions have the same denominator. Both 2/7 and 5/7 have denominator 7."
                ),
            ),
        ) }
        // endregion
    }
}
