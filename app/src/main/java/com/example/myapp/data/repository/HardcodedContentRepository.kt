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
                Module("it_mongo_ch1_m1", "it_mongo_ch1", "SQL vs NoSQL: Ek Introduction", 1),
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
        private val contentBlocks = mapOf(
            "it_mongo_ch1_m1" to listOf(
                ContentBlock.TextBlock(
                    "🗄️ Database kya hota hai?\n\nDatabase ek organized collection hoti hai structured information ya data ki, jo electronically store hoti hai. Simple shabdon mein — database ka kaam hai tumhari information ko organized aur easily accessible rakhna. 📂"
                ),
                ContentBlock.TextBlock(
                    "📊 SQL Database kya hai?\n\nSQL database information ko relational format mein store karta hai — matlab data tables mein hota hai, aur un tables ke beech predefined relationships hote hain. 🔗\n\nYe relational model data redundancy avoid karta hai by storing linked information in separate tables."
                ),
                ContentBlock.ExampleBlock(
                    "🛒 SQL ka real example",
                    "Maan lo ek e-commerce app hai jisme customer orders track hote hain:\n\n📋 CUSTOMER ORDERS table → order details store karta hai\n👤 CUSTOMER DETAILS table → naam, email, address store karta hai\n🏪 STORES table → store ya website info store karta hai\n\nYe teeno tables ek common field (jaise customer_id, store_id) ke through linked hote hain. 🔗\n\nJab order #1104 ki full detail chahiye, to Orders aur Customers tables ko JOIN karke data lena padta hai."
                ),
                ContentBlock.TextBlock(
                    "🚀 NoSQL Database kya hai?\n\nNoSQL databases data ko non-tabular format mein store karte hain — yani tables nahi hoti! Ye SQL se bilkul alag approach hai.\n\nNoSQL ke kai types hote hain:\n\n📄 Document Databases (e.g. MongoDB) — is course ka focus\n🔑 Key-Value Databases — simplest type, har key unique hoti hai\n📐 Wide Column Databases — columns-oriented storage\n🕸️ Graph Databases — highly interrelated data ke liye"
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
                    "🛠️ Do Zaroori Tools — Mongo Shell & DB Tools\n\nAtlas cluster set up ho gaya, ab hume do tools install karne hain:\n\n💻 Mongo Shell (mongosh)\n   Terminal se directly Atlas cluster se baat karo\n   Queries run karo, data dekho\n\n📦 MongoDB Database Tools\n   Import/export jaisi operations ke liye\n   Bulk data handle karna\n\nDono tools ka flow:\nTerminal → Mongo Shell → Atlas Cluster\n              ↑\n          DB Tools\n          (import/export)"
                ),
                ContentBlock.ExampleBlock(
                    "🍎 Mac OS — Mongo Shell Install Karo",
                    "1️⃣  Jaao: mongodb.com/try/download/shell\n\n2️⃣  Platform select karo:\n    → Mac OS, 64-bit version\n       (M1 chip ho to M1 bhi chalega)\n\n3️⃣  Download ho jayega → Downloads folder\n\n4️⃣  File double click karo → Extract\n\n5️⃣  Extracted folder → bin folder open karo\n\n6️⃣  bin ke andar dono files select karo\n    → Copy karo (Cmd + C)\n\n7️⃣  Hidden folders show karo:\n    → Cmd + Shift + . (dot)\n\n8️⃣  Navigate karo:\n    User → local → bin\n    (/usr/local/bin)\n\n9️⃣  Files yahan Paste karo (Cmd + V)\n\n✅ Mongo Shell install complete!"
                ),
                ContentBlock.ExampleBlock(
                    "✅ Mac — Test Karo + Security Fix",
                    "Test karo:\n\n1️⃣  Terminal open karo:\n    Cmd + Space → \"terminal\" type karo\n\n2️⃣  Ye command type karo:\n    mongosh --help\n\n3️⃣  Agar output dikhe → ✅ Success!\n\n─────────────────────────────────\n⚠️  Mac block kare to kya karein?\n\nMac OS kabhi-kabhi unknown apps\nblock kar deta hai. Agar error aaye:\n\n1️⃣  System Preferences kholo\n       → Security & Privacy\n       → General tab\n\n2️⃣  Warning dikhegi mongosh ke baare mein\n\n3️⃣  Lock icon unlock karo (password daalo)\n\n4️⃣  \"Open Anyway\" / \"Allow Anyway\"\n    par click karo\n\n5️⃣  Dobara terminal mein test karo ✅"
                ),
                ContentBlock.ExampleBlock(
                    "🍎 Mac OS — Database Tools Install Karo",
                    "1️⃣  mongodb.com/try/download/database-tools\n    par jaao\n\n2️⃣  Mac platform select karo → Download\n\n3️⃣  Downloads folder → bin folder open karo\n    (Is baar multiple files hongi —\n     har file ek alag task ke liye)\n    📄 mongoimport\n    📄 mongoexport\n    📄 mongodump\n    📄 mongorestore ... aur bhi\n\n4️⃣  Sabhi files copy karo\n\n5️⃣  /usr/local/bin mein paste karo\n    (same jagah jahan mongosh rakha tha)\n\n6️⃣  Test karo — terminal mein type karo:\n    mongoexport --help\n\n✅ Agar output aaye → Installation done!\n⚠️  Block kare to same security fix follow karo"
                ),
                ContentBlock.ExampleBlock(
                    "🪟 Windows — Mongo Shell Install Karo",
                    "1️⃣  mongodb.com/try/download/shell par jaao\n\n2️⃣  Platform: Windows select karo\n    → ZIP package download karo\n       (MSI nahi, ZIP chahiye!)\n\n3️⃣  File apni desired location par save karo\n    → Example: Desktop\n\n4️⃣  Folder unzip karo → bin folder open karo\n\n5️⃣  Path copy karo:\n    Executable file par Right Click\n    → Properties → Location copy karo\n\n6️⃣  PATH variable mein add karo:\n    🔍 Windows Search → \"environment variables\"\n    → \"Edit the system environment variables\"\n    → Environment Variables button\n    → System Variables → Path → Edit\n    → New → Copied path paste karo → OK\n\n7️⃣  Test karo — CMD open karo:\n    mongosh --help\n\n✅ Commands dikhe → Setup sahi hai!\n\nPATH Variable → executable files → CMD se run"
                ),
                ContentBlock.ExampleBlock(
                    "🪟 Windows — Database Tools Install Karo",
                    "Same process, alag download:\n\n1️⃣  mongodb.com/try/download/database-tools\n\n2️⃣  Windows version download karo → Extract karo\n\n3️⃣  bin folder ka path copy karo\n\n4️⃣  Environment Variables → Path → New\n    → Copied path paste karo → OK\n\n5️⃣  Final test — CMD mein type karo:\n    mongoexport --help\n\n✅ Valid output aaye → Sab sahi hai! 🎉\n\n─────────────────────────────────\n🏁 DONE — Dono tools install ho gaye:\n\n✅ mongosh       → Shell ready\n✅ mongoexport   → DB Tools ready\n\nKoi bhi issue ho to Q&A mein\nzaroor poochho! 🙋"
                ),
            ),
            "it_mongo_ch2_m2" to listOf(
                ContentBlock.TextBlock(
                    "☁️ Atlas Cluster Setup — Chalo Shuru Karte Hain!\n\nIs module mein hum step-by-step MongoDB Atlas par apna pehla cluster set up karenge.\n\n✅ Bilkul FREE — koi credit card nahi chahiye\n✅ 512 MB storage milegi\n✅ Training ke liye bilkul perfect\n\nSabse pehle jaao: www.mongodb.com/try 🌐"
                ),
                ContentBlock.ExampleBlock(
                    "📋 Step 1 — Sign Up aur Account Banana",
                    "1️⃣  mongodb.com/try par jaao\n\n2️⃣  Atlas select karo\n\n3️⃣  Right side ka form fill karo:\n    • \"How are you using MongoDB?\"\n       → \"I'm learning\" select karo\n    • Email address enter karo\n    • Personal details bharo\n    • Terms agree karo\n\n4️⃣  \"Get Started for Free\" par click karo\n\n5️⃣  📧 Email check karo\n    Verification link par click karo\n\n6️⃣  Kuch onboarding questions answer karo\n\n✅ Account ready!\n\nSign Up → Verify Email → Deploy Cluster"
                ),
                ContentBlock.ExampleBlock(
                    "🖥️ Step 2 — Cluster Deploy Karo (Free Tier)",
                    "Cluster deploy karne ka option aayega:\n\n1️⃣  Deployment type:\n    → 🆓 Shared (FREE) select karo\n\n2️⃣  Cloud Provider & Region:\n    → Default theek hai\n    → Apne closest FREE region choose karo\n       (India ke liye: Mumbai ya Singapore)\n\n3️⃣  Cluster Tier:\n    → M0 FREE tier select karo\n    → 💾 512 MB storage\n    → No credit card!\n\n4️⃣  Cluster ka naam do:\n    → Example: \"sandbox\"\n       (training ke liye descriptive naam)\n\n5️⃣  \"Create Cluster\" par click karo\n\n⏳ Cluster deploy hone mein ~2-3 min lagte hain"
                ),
                ContentBlock.ExampleBlock(
                    "👤 Step 3 — Database User Banana",
                    "Cluster ready hone ke baad kuch setup steps:\n\n📌 Left panel → \"Database Access\" → \"Add New User\"\n\n1️⃣  Username choose karo\n    → Example: user1\n\n2️⃣  Password set karo\n    → Strong password rakho! 🔐\n\n3️⃣  Privileges set karo:\n    → ⚠️ \"Atlas Admin\" select karo\n       (Ye bahut important hai!)\n\n4️⃣  \"Add User\" par click karo\n\n💡 Ye user wahi credentials hain jo tum\n   Terminal ya Compass se connect karte\n   waqt use karoge:\n\n   User → (username + password) → Atlas Cluster"
                ),
                ContentBlock.ExampleBlock(
                    "🌐 Step 4 — Network Access Allow Karo",
                    "📌 Left panel → \"Network Access\" → \"Add IP Address\"\n\n1️⃣  \"Add IP Address\" par click karo\n\n2️⃣  IP address field mein enter karo:\n    →  0.0.0.0/0\n\n3️⃣  \"Confirm\" par click karo\n\n─────────────────────────────────\n0.0.0.0 ka matlab:\n🌍 Kisi bhi IP address se access allowed\n\n⚠️  Note: Ye sirf training ke liye hai!\nProduction mein hamesha specific\nIP addresses whitelist karo.\n─────────────────────────────────\n\n✅ Ab tum apna cluster kahi se bhi\n   access kar sakte ho!"
                ),
                ContentBlock.TextBlock(
                    "🎉 Cluster Ready — Aage Kya?\n\nBadhaai ho! 🥳 Tumhara Atlas account aur cluster set up ho gaya hai.\n\nAb aage ye karna hoga:\n\n🔜 Mongo Shell install karna\n   Terminal se database access ke liye\n\n🔜 MongoDB Compass install karna\n   GUI se database dekho aur manage karo\n\n🔜 Sample Data load karna\n   Practice ke liye ready-made data\n\n🔜 Interfaces ka proper overview\n   Sab kuch use karna seekhenge\n\n💡 Koi bhi problem aaye to Q&A section\n   mein zaroor poochho — hum help karenge! 🙋"
                ),
            ),
            "it_mongo_ch2_m1" to listOf(
                ContentBlock.TextBlock(
                    "💬 MQL — MongoDB se Baat Karne Ka Tarika\n\nMongoDB ke saath communicate karne ke liye hum use karte hain:\n\n📌 MQL — Mongo Query Language\n\nMQL ek imperative language hai — matlab tum MongoDB ko directly batate ho ki kya karna hai, step by step. Ye seekhna zyada mushkil nahi hai! 😊\n\nMQL specifically simple queries ke liye design ki gayi hai jo single collections par chalti hain."
                ),
                ContentBlock.ExampleBlock(
                    "🔁 MQL Kaise Kaam Karta Hai",
                    "MQL ka basic flow:\n\n👤 User\n    ↓  query likhta hai\n📝 MQL Query\n    ↓  MongoDB ko bhejta hai\n🍃 MongoDB\n    ↓  query execute karta hai\n📦 Result\n\nExample query (simple format mein):\ndb.customers.find({ city: \"Delhi\" })\n           ↑           ↑\n      collection     filter\n\n✅ Imperative — tum batao kya chahiye\n✅ Simple syntax\n✅ Single collection par kaam karta hai"
                ),
                ContentBlock.TextBlock(
                    "🔀 Aggregation Pipeline — Complex Queries Ke Liye\n\nJab query simple na ho — jaise pehle data filter karo, phir group karo, phir sort karo — tab MQL ki jagah hum MongoDB Aggregation Pipeline use karte hain. 🚀\n\nAggregation Pipeline operations ko multiple stages mein break karta hai. Har stage pichli stage ka output le ke apna kaam karta hai — bilkul ek assembly line ki tarah! 🏭"
                ),
                ContentBlock.ExampleBlock(
                    "🏭 Aggregation Pipeline — Stage by Stage",
                    "Example: Pehle filter karo, phir group karo\n\n📥 INPUT DATA (poori collection)\n         ↓\n┌─────────────────────────┐\n│  🔍 Stage 1: FILTER     │\n│  Sirf Delhi ke customers│\n└─────────────────────────┘\n         ↓\n┌─────────────────────────┐\n│  📊 Stage 2: GROUP      │\n│  City ke hisaab se      │\n│  group karo             │\n└─────────────────────────┘\n         ↓\n📤 FINAL RESULT\n\n💡 Key rule: Stages usi order mein execute\n   hoti hain jis order mein likhi hain!\n\nAur stages:\nStage 1 → Stage 2 → Stage 3 → ... → Result"
                ),
                ContentBlock.TextBlock(
                    "🗺️ Is Course Mein Hum Kya Karenge?\n\n📌 MQL — Abhi cover karenge\n   Simple queries, CRUD operations,\n   single collections par kaam karna\n\n📌 Aggregation Pipeline — Baad mein\n   Complex multi-stage queries\n   Filtering + Grouping + Sorting together\n\n🎯 Dono tools milake tumhe MongoDB par\n   complete control de denge! Chalo shuru karte hain! 🚀"
                ),
            ),
            "it_mongo_ch1_m6" to listOf(
                ContentBlock.TextBlock(
                    "🏆 MongoDB ke Advantages — Ek Complete Summary\n\nIs module mein humne bahut kuch cover kiya — ab waqt hai sab kuch ek jagah consolidate karne ka. Yahan hain MongoDB ke sabse important advantages jo ise SQL se alag aur powerful banate hain! 💪"
                ),
                ContentBlock.ExampleBlock(
                    "⚔️ SQL vs MongoDB — Structure Comparison",
                    "SQL mein data alag-alag tables mein hota hai:\n\n📋 Customers Table\n        ↕ linked\n📋 Orders Table\n        ↕ linked\n📋 Stores Table\n\nEk query ke liye:\nOrders ── JOIN ── Customers ── JOIN ── Stores\n❌ Multiple tables\n❌ Complex JOINs\n❌ Zyada tables = zyada complexity\n\n─────────────────────────────────\n\nMongoDB mein sab kuch ek document mein:\n\n{\n  name: \"Anurag\",\n  orders: [\n    { id: 101 },\n    { id: 102 }\n  ]\n}\n✅ Ek query, ek document\n✅ No JOINs needed\n✅ Simple aur fast!"
                ),
                ContentBlock.ExampleBlock(
                    "🔄 Flexibility — Alag Fields, Alag Data Types",
                    "MongoDB mein same collection ke documents alag ho sakte hain:\n\n📄 Doc 1:\n{ name: \"Anurag\", city: \"Delhi\" }\n\n📄 Doc 2:\n{ name: \"Rahul\", phone: \"9999\" }\n← extra field, koi problem nahi! ✅\n\nEk hi field mein alag data types bhi allowed hain:\n\n📄 Doc 1: { \"value\": \"hello\" }      → String\n📄 Doc 2: { \"value\": \"2024-01-01\" } → Date\n\n✅ Embedded documents possible\n✅ Arrays possible\n✅ Mixed data types possible\n✅ Ek collection mein zyada data"
                ),
                ContentBlock.TextBlock(
                    "📝 Schemaless — Change Karo Jab Chahiye!\n\nMongoDB schemaless hota hai — koi fixed structure nahi hoti.\n\nIska matlab:\n✅ Nayi field add karni hai? Bas likho — done!\n✅ Kisi field ki zaroorat nahi? Remove karo — no impact\n✅ Data format change karna hai? Koi migration nahi\n\nSQL mein ek naya column add karne ke liye:\n❌ Table alter karni padti hai\n❌ NULL values bhar jaati hain\n❌ Related tables impact hoti hain\n❌ Constraints check karne padte hain\n\nMongoDB mein? Seedha naya field-value pair likhdo! ✍️"
                ),
                ContentBlock.ExampleBlock(
                    "🔧 Maintenance — SQL vs MongoDB",
                    "SQL database maintain karna:\n❌ Foreign keys manage karne padte hain\n❌ Multiple tables ke beech relationships maintain karni padti hain\n❌ Schema changes complex hote hain\n❌ Constraints aur cascades handle karne padte hain\n\n─────────────────────────────────\n\nMongoDB maintain karna:\n✅ No foreign keys\n✅ No strict relationships to manage\n✅ Schema flexible hai — change easy hai\n✅ Ek document mein sab kuch → simpler queries\n\n💡 Generally MongoDB ka maintenance\n   relational databases se kaafi easy hota hai!"
                ),
                ContentBlock.ExampleBlock(
                    "📈 Horizontal Scaling — Grow Karo Jaise Chahiye",
                    "SQL → Vertical Scaling (ek server ka size badhao)\n   🖥️ Bada server → expensive, limit hoti hai\n\n─────────────────────────────────\n\nMongoDB → Horizontal Scaling (aur servers jodo)\n\nStep 1 — Shuru mein:\n🖥️ Server 1\n\nStep 2 — Data badha:\n🖥️ Server 1  +  🖥️ Server 2\n\nStep 3 — Aur badha:\n🖥️ Server 1  +  🖥️ Server 2  +  🖥️ Server 3\n                       ↓\n              🗂️ MongoDB Cluster\n\n✅ Jab chahiye add karo — easy!\n✅ Big data? No problem! 🚀\n✅ Aaj ke data demands ke liye perfect"
                ),
                ContentBlock.TextBlock(
                    "🎯 MongoDB ke Top Advantages — Quick Recap\n\n1️⃣  🔄  Flexible Schema\n        Alag-alag documents, alag-alag fields\n        No fixed structure\n\n2️⃣  📦  Embedded Documents & Arrays\n        Related data ek hi document mein\n        No complex JOINs\n\n3️⃣  📝  Schemaless\n        Changes karna easy\n        Evolving data ke liye perfect\n\n4️⃣  🔧  Easy Maintenance\n        No foreign keys\n        No relationship management\n\n5️⃣  📈  Horizontal Scaling\n        Cluster mein servers add karo\n        Big data easily handle hota hai\n\n🍃 Yehi wajah hai ki MongoDB aaj duniya ke\n   most popular databases mein se ek hai!"
                ),
            ),
            "it_mongo_ch1_m5" to listOf(
                ContentBlock.TextBlock(
                    "🔁 Replica Sets — Data Ki Safety Net\n\nMongoDB ke common deployments mein do important concepts hain — Replica Sets aur Sharded Clusters.\n\nEk Replica Set 3 machines (instances) se milkar banta hai. Teeno machines par data ka complete copy hota hai. Agar ek machine fail ho jaaye — koi tension nahi! Baaki do machines par data safe aur available rehta hai. 🛡️"
                ),
                ContentBlock.ExampleBlock(
                    "🔁 Replica Set — 3 Instances Ka Group",
                    "🔁  REPLICA SET\n├── 🟢 Instance 1 — PRIMARY\n│       Writes yahan hoti hain\n│       (main machine)\n│\n├── 🔵 Instance 2 — SECONDARY\n│       Primary ka exact copy\n│       (backup #1)\n│\n└── 🔵 Instance 3 — SECONDARY\n        Primary ka exact copy\n        (backup #2)\n\n✅ Teeno mein same data hota hai\n✅ Primary fail ho to Secondary\n   automatically Primary ban jaata hai\n✅ Data kabhi lost nahi hota 🛡️"
                ),
                ContentBlock.TextBlock(
                    "🗂️ Sharded Cluster — Data Ko Baanto, Load Kam Karo\n\nJab data itna zyada ho jaaye ki ek machine par fit na ho, tab Sharded Cluster use hota hai.\n\nEk Sharded Cluster multiple Replica Sets ka group hota hai. Data ko alag-alag partitions (shards) mein split kar diya jaata hai aur har shard ek alag Replica Set par store hota hai. 📦📦📦"
                ),
                ContentBlock.ExampleBlock(
                    "⚙️ Sharded Cluster ke 3 Components",
                    "Ek sharded cluster mein teen types ke components hote hain:\n\n📱  APPLICATION\n         ↓\n🔀  MONGOS  (Query Router)\n         Ye application aur\n         shards ke beech\n         traffic direct karta hai\n         ↓\n┌────────────────────┐\n├── 📦 Shard 1 (Replica Set)\n├── 📦 Shard 2 (Replica Set)\n└── 📦 Shard 3 (Replica Set)\n         ↑\n⚙️  CONFIG SERVERS\n         Metadata aur settings\n         store karte hain\n\n🔹 Shard    → data ka ek partition\n🔹 Mongos   → smart router\n🔹 Config   → cluster ka brain"
                ),
                ContentBlock.ExampleBlock(
                    "🔑 Sharding Example — Shard Key se Data Baantna",
                    "Maan lo tumhare paas millions of customers hain.\nMongoDB ek Shard Key choose karta hai data distribute karne ke liye.\n\nExample: Shard key = customer ka first name\n\nCOLLECTION (Customer Info)\n         ↓  [shard key: name]\n┌────────────────────────┐\n│ 📦 Shard 1 → A se H   │ (Anurag, Bharat, Diya...)\n│ 📦 Shard 2 → I se P   │ (Isha, Kumar, Neha...)\n│ 📦 Shard 3 → Q se Z   │ (Rahul, Vikram, Zoya...)\n└────────────────────────┘\n\n💡 Har shard apne data ka Replica Set maintain karta hai\n   → High availability + distributed storage!"
                ),
                ContentBlock.TextBlock(
                    "🏆 MongoDB Distribution ke 3 Key Benefits\n\n🛡️ Fault Tolerance\n   Data ke replicas alag-alag servers par hote hain.\n   Ek machine fail ho — data safe rehta hai.\n\n📈 Scalability\n   Data badhe to aur shards add karo.\n   Storage aur performance dono scale hoti hain.\n\n🌍 Data Locality — Users ke Paas Data\n   Tum data ko users ke geographically close rakh sakte ho:\n\n   🇪🇺 Users (Europe)  → Server (Europe)\n   🇺🇸 Users (America) → Server (America)\n\n   Iska faayda? Faster response time kyunki data door nahi jaata! ⚡"
                ),
            ),
            "it_mongo_ch1_m4" to listOf(
                ContentBlock.TextBlock(
                    "🌍 MongoDB Ecosystem ka Overview\n\nMongoDB sirf ek database nahi hai — ye ek poora ecosystem hai products aur tools ka. Is module mein hum dekhenge ki MongoDB ke paas kya-kya available hai aur hum is course mein kya use karenge.\n\nSabse pehle baat karte hain deployment options ki — yani MongoDB kahan run karega."
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
                    "🔧 Supporting Tools — MongoDB ke Saath Kaam Karne ke Tarike",
                    "MongoDB ke saath interact karne ke kai tarike hain:\n\n🔧  DATABASE TOOLS\n│\n├── 💻  Mongo Shell\n│       Terminal se directly MongoDB\n│       se baat karo\n│       User → Terminal → Shell → DB\n│\n├── 🔌  MongoDB Drivers\n│       Apni favorite language mein\n│       queries likho!\n│       JavaScript, Python, Java...\n│\n├── 📈  BI Connectors\n│       MongoDB ko analytics tools\n│       se connect karo\n│       QlikSense, Tableau...\n│\n└── 🧭  MongoDB Compass\n        GUI (Graphical Interface)\n        Click karke MongoDB use karo\n        User → Compass → MongoDB"
                ),
                ContentBlock.TextBlock(
                    "🎯 Is Course Mein Hum Kya Use Karenge?\n\nAb tum poora ecosystem jaante ho! Is course mein primarily yahi use hoga:\n\n✅ MongoDB Atlas — humara main database (free tier)\n✅ Mongo Shell — queries likhne ke liye\n📊 MongoDB Charts — thoda cover karenge\n🔌 MongoDB Drivers — thoda cover karenge\n\n💡 Shuru karne ke liye bas ek free Atlas account chahiye — aur hum ready hain! 🚀"
                ),
            ),
            "it_mongo_ch1_m3" to listOf(
                ContentBlock.TextBlock(
                    "📋 JSON Format — MongoDB Documents ka Aadhar\n\nMongoDB mein documents JSON format mein likhe jaate hain.\nJSON ka full form hai: JavaScript Object Notation 📝\n\nJSON likhne ke 5 zaroori rules:\n\n1️⃣  Document curly braces { } se start aur end hona chahiye\n2️⃣  Data key-value pairs mein hota hai\n3️⃣  Key aur value ke beech colon  :  hota hai\n4️⃣  Keys hamesha double quotes \" \" mein honi chahiye\n5️⃣  String values bhi double quotes mein, numbers bina quotes ke\n6️⃣  Alag-alag key-value pairs comma , se separate hote hain"
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
                    "📄 Ek MongoDB Document kaisa dikhta hai?",
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
                    "⚠️ SQL mein yahi kaam kitna mushkil hota",
                    "SQL mein agar phone number add karna ho, to poori table mein naya column dalna padega:\n\nID  | Name   | Email           | Address | Phone\n----|--------|-----------------|---------|----------\n 1  | Anurag | anurag@gmail.com| Delhi   | NULL ❌\n 2  | Rahul  | rahul@gmail.com | Mumbai  | 9999999999\n\nProblems:\n❌ Jahan data nahi hai wahan NULL values bhar jaati hain\n❌ Table constraints aur related tables ka impact consider karna padta hai\n❌ Jaise-jaise columns badhte hain, NULL aur redundant data bhi badhta hai"
                ),
                ContentBlock.TextBlock(
                    "✅ MongoDB kyun better hai?\n\nMongoDB ki flexible nature ki wajah se:\n\n⚡ Naya field sirf us document mein add karo jisme chahiye\n⚡ Baaki documents affected nahi hote\n⚡ Koi NULL values nahi, koi extra columns nahi\n⚡ Data structure mein changes karna bahut simple hai\n\n💡 Har document sirf wahi field-value pairs rakhta hai jo usse zaroori hote hain — nothing more, nothing less!"
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
                    "📦 Sample Data Load Karna — Course Ka Practice Data\n\nIs module mein hum woh sample data install karenge jo hum is course ke aane wale saare modules mein use karenge.\n\nSabse easy tarika hai — Compass ke through karna! 🧭\n\nPehle humhe Atlas se apna Compass connect karna hoga."
                ),
                ContentBlock.ExampleBlock(
                    "🔌 Step 1 — Compass ko Atlas se Connect Karo",
                    "1️⃣  Atlas mein login karo:\n    mongodb.com/cloud/atlas\n\n2️⃣  Apne project par navigate karo\n    (Example: \"Project Zero\")\n\n3️⃣  \"Connect\" button par click karo\n\n4️⃣  \"Connect using MongoDB Compass\"\n    select karo\n\n5️⃣  Connection string copy karo 📋\n\n─────────────────────────────────\nAtlas → Connection String → Compass\n─────────────────────────────────\n\n6️⃣  Compass open karo\n    (Mac: Finder se search karo agar\n     dock mein nahi hai)\n\n7️⃣  Connection string paste karo\n    + apna password enter karo\n\n8️⃣  Connect!\n\n✅ Ab tum cluster se connected ho!"
                ),
                ContentBlock.TextBlock(
                    "⚠️  System Databases — Inhe Delete Mat Karna!\n\nConnect hone ke baad tumhe teen databases dikhenge:\n\n🔒 admin\n🔒 config\n🔒 local\n\nYe teen MongoDB ke system-generated databases hain.\nYe automatically bante hain aur internal kaam ke liye hote hain.\n\n❌ Inhe kabhi delete mat karna — cluster break ho sakta hai!"
                ),
                ContentBlock.ExampleBlock(
                    "🗄️ Step 2 — Sample Database aur Collection Banana",
                    "Left side panel ke neeche ek ➕ plus icon dikhega.\n\n1️⃣  Plus icon par click karo\n    → \"Create Database\" window khulega\n\n2️⃣  Database name daalo:\n    sample_training\n    (lowercase mein!)\n\n3️⃣  Collection name daalo:\n    companies\n    (lowercase mein!)\n\n4️⃣  \"Create Database\" par click karo\n\n─────────────────────────────────\n📁 Database:   sample_training\n📂 Collection: companies\n─────────────────────────────────\n\n⚠️  Naam bilkul same rakho —\n   uppercase/space galat ho jaayega!"
                ),
                ContentBlock.ExampleBlock(
                    "📥 Step 3 — JSON Files Download aur Import Karo",
                    "Lecture ke resources section se ZIP file download karo.\nDesktop par save karo → Extract/Unzip karo.\n\nsample_training folder mein 7 JSON files hongi:\n📄 companies.json\n📄 grades.json\n📄 inspections.json\n📄 routes.json\n📄 trips.json\n📄 zips.json\n📄 (+ 1 aur)\n\n─────────────────────────────────\n🔁 Har collection ke liye yahi process:\n─────────────────────────────────\n\n1️⃣  Collection par click karo\n    (e.g. companies)\n\n2️⃣  \"Add data\" → \"Import file\"\n\n3️⃣  Matching JSON file select karo\n    (companies.json for companies)\n\n4️⃣  Import complete! Documents load ✅\n\n─────────────────────────────────\ncompanies.json → companies collection\ngrades.json   → grades collection\n   ... baaki 5 bhi same tarah\n─────────────────────────────────\n\n✅ Saari 7 collections import ho gayi!"
                ),
                ContentBlock.TextBlock(
                    "🧭 Compass Ka Quick Overview\n\nSab data load hone ke baad Compass ka layout samjho:\n\n📌 Left Panel\n   → Cluster connections\n   → Databases list\n   → Collections list\n\n📌 Top Ribbon\n   → Database options\n   → Performance metrics\n\n📌 Main Area\n   → Collections aur Documents\n\n─────────────────────────────────\nLeft Panel  →  Databases\nTop         →  Metrics\nMain        →  Collections & Documents\n─────────────────────────────────\n\n📌 Sabse Neeche — mongosh\n\nCompass ke bottom mein mongosh (Mongo Shell) dikhega.\nIs course mein hum mainly Terminal / CMD ke through mongosh use karenge — kyunki wahan zyada operations possible hain.\n\n─────────────────────────────────\nTerminal / CMD → mongosh → MongoDB\n─────────────────────────────────\n\n🎯 Sample data ready hai — ab asli queries likhne ka time! 🔥"
                ),
            ),
            "it_mongo_ch2_m4" to listOf(
                ContentBlock.TextBlock(
                    "🧭 MongoDB Compass — GUI se Database Dekho!\n\nAbhi tak humne terminal tools install kiye — Mongo Shell aur DB Tools. Ab ek aur powerful tool install karna hai:\n\n🖥️ MongoDB Compass\n   → Ek graphical interface (GUI) hai\n   → Database ko visually dekho aur manage karo\n   → Queries bhi run kar sakte ho — bina terminal ke!\n   → Beginners ke liye bahut helpful hai\n\nCompass ek window ki tarah hai jo tumhara Atlas cluster dikhata hai — seedha browser jaisa! 🌐"
                ),
                ContentBlock.ExampleBlock(
                    "🍎 Mac OS — Compass Install Karo",
                    "1️⃣  Jaao: www.mongodb.com\n\n2️⃣  Top menu:\n    Products → Tools → Compass\n    (Ya seedha scroll karke Compass section dhundho)\n\n3️⃣  Download karo:\n    → Mac OS select karo\n    → Package download hoga (.dmg file)\n\n4️⃣  Downloaded file double click karo\n    → Ek window khulega\n\n5️⃣  MongoDB Compass icon ko\n    Applications folder mein drag karo\n\n6️⃣  Applications mein jaao → Compass open karo\n\n7️⃣  Optional: Dock mein rakhna ho to\n    → Compass icon par Right Click karo\n    → Options → Keep in Dock\n\n✅ Compass install ho gaya!\n\n─────────────────────────────────\n⚠️  Mac block kare to kya karein?\n\n1️⃣  System Preferences kholo\n    → Security & Privacy → General tab\n\n2️⃣  Compass ke baare mein warning dikhegi\n\n3️⃣  Lock icon unlock karo\n\n4️⃣  \"Allow Anyway\" par click karo\n\n5️⃣  Dobara open karo ✅"
                ),
                ContentBlock.ExampleBlock(
                    "🪟 Windows — Compass Install Karo",
                    "1️⃣  Jaao: www.mongodb.com\n    → Products → Tools → Compass\n\n2️⃣  Windows select karo:\n    → ⚠️  MSI package download karo\n       (ZIP nahi! MSI installer chahiye)\n\n3️⃣  Downloaded .msi file par double click karo\n    → Installer window khulega\n\n4️⃣  Installation wizard follow karo:\n    → Next → Next → Install\n    → Finish\n\n5️⃣  Compass automatically open ho jaayega\n    Ya Start Menu se dhundh sakte ho\n\n✅ Windows par bhi Compass ready! 🎉"
                ),
                ContentBlock.TextBlock(
                    "🔌 Compass se Atlas Cluster Connect Karo\n\nCompass install hone ke baad yahi steps follow karo:"
                ),
                ContentBlock.ExampleBlock(
                    "🔌 Compass — Atlas se Connect Karo",
                    "1️⃣  Compass open karo\n    → Ek connection screen dikhega\n\n2️⃣  Atlas Dashboard mein jaao\n    → Apne cluster ke paas \"Connect\" button\n    → \"Connect using MongoDB Compass\" option\n\n3️⃣  Connection string copy karo:\n    mongodb+srv://username:password@cluster-url/database\n\n4️⃣  Compass mein connection string paste karo\n    → Apna password bhi enter karo → Connect!\n\n✅ Ab tumhara database visually dikhega —\n   collections, documents, aur sab kuch!"
                ),
            ),
            "it_mongo_ch2_m6" to listOf(
                ContentBlock.TextBlock(
                    "🌐 MongoDB Atlas — Interface Ka Overview\n\nIs module mein hum MongoDB Atlas ka pura interface explore karenge — kahan kya milta hai, kab kya use karna hai.\n\nAtlas mein login karne ke baad pehle Organization view dikhega.\nOrganization ke andar Projects hote hain.\n\n─────────────────────────────────\nOrganization → Projects → Clusters\n─────────────────────────────────\n\nApna project \"Project Zero\" dikhega.\nIse rename karne ke liye:\n3 dots → \"Edit Project\" → naam daalo\n(Example: \"training\")"
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
                    "🗂️ Cluster aur Collections Dekhna\n\nAtlas Overview par:\n\nHamare cluster mein 3 nodes hain —\nkyunki humne 3 machines ka Replica Set deploy kiya hai.\n\n─────────────────────────────────\nCluster (Replica Set)\n├── Node 1\n├── Node 2\n└── Node 3\n─────────────────────────────────\n\nCluster ke andar \"Browse Collections\" par click karo:\n\n─────────────────────────────────\nsample_training\n├── companies\n├── grades\n└── ... (baaki collections)\n─────────────────────────────────\n\nAtlas se directly in collections ko query bhi kar sakte ho!\n\n⚠️  Baaki options jaise Search, Profiler,\n   Performance Advisor, Online Archive —\n   is course mein focus nahi karenge.\n\n🎯 Hum mainly use karenge:\n   ✅ Compass (GUI)\n   ✅ mongosh (CLI / Terminal)"
                ),
            ),
            "it_mongo_ch2_m7" to listOf(
                ContentBlock.TextBlock(
                    "🔁 Sab Kuch Ek Saath — Recap!\n\nHumne kaafi saare components install kiye hain. Is module mein hum dekhenge ki ye sab ek doosre se kaise connect hote hain — ek complete picture.\n\nShuru karte hain MongoDB Atlas se. 🚀"
                ),
                ContentBlock.ExampleBlock(
                    "🌐 Atlas — Central Hub",
                    "MongoDB Atlas hamare cluster ko manage karta hai.\nAur directly databases aur collections access karne ki suvidha deta hai.\n\n─────────────────────────────────\nAtlas → Manage Cluster + View Data (GUI)\n─────────────────────────────────\n\n\"Connect\" par click karo to 2 options milte hain:\n\n─────────────────────────────────\nAtlas → Connect →\n  ├── mongosh  (Terminal / CMD)\n  └── Compass  (GUI)\n─────────────────────────────────\n\nDono tarike already setup ho chuke hain! ✅"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Terminal se mongosh Connect Karna",
                    "Atlas → \"Connect\" → \"Connect to Shell\"\n\n1️⃣  Dropdown se \"mongosh\" select karo\n\n2️⃣  Connection string copy karo\n\n3️⃣  Terminal (Mac) ya CMD (Windows) open karo\n\n4️⃣  Connection string paste karo → Enter\n\n✅ Cluster se connect ho gaye!\n\n─────────────────────────────────\nTerminal → paste connection string\n         → Connected to Cluster\n─────────────────────────────────\n\n5️⃣  Test karo — type karo:\n    show dbs\n\n    → Saare databases ki list dikhegi\n    → sample_training bhi dikhega\n       (jo humne pehle banaya tha) ✅\n\n─────────────────────────────────\n6️⃣  Disconnect karna ho to:\n    exit     → MongoDB se disconnect\n    (ya terminal/CMD band kar do)\n─────────────────────────────────"
                ),
                ContentBlock.TextBlock(
                    "📦 DB Tools — Import/Export ke Liye\n\nHumne MongoDB Database Tools bhi install kiye hain:\n📄 mongoimport\n📄 mongoexport\n\nYe tools directly Terminal ya CMD ke saath connect hote hain:\n\n─────────────────────────────────\nDB Tools → Terminal → MongoDB\n          (import / export)\n─────────────────────────────────\n\nAur Compass:\n\n─────────────────────────────────\nCompass (GUI) → Cluster → Data View\n─────────────────────────────────\n\n🎯 Chapter 2 — Complete Setup Summary:\n\n✅ MQL — Query language samjhi\n✅ Atlas Cluster setup kiya (Free)\n✅ Mongo Shell (mongosh) install kiya\n✅ DB Tools install kiye (import/export)\n✅ MongoDB Compass install kiya\n✅ Sample data load kiya\n✅ Atlas interface explore kiya\n✅ mongosh se cluster connect kiya\n\nAb hum practically operations perform\nkarne ke liye ready hain! 🔥"
                ),
            ),
            "it_mongo_ch3_m1" to listOf(
                ContentBlock.TextBlock(
                    "💻 Command Line Basics — Terminal Navigate Karna\n\nIs module mein hum sikhenge ki terminal ya command prompt mein basic navigation commands kaise use karte hain.\n\nAgle modules mein hume terminal mein specific directories mein jaana hoga — isliye ye basics zaroori hain! 🗺️\n\n📌 Mac → Terminal use hota hai\n📌 Windows → Command Prompt (CMD) use hoti hai"
                ),
                ContentBlock.ExampleBlock(
                    "📍 pwd / cd — Kahan Ho Tum?",
                    "Apni current location jaanne ke liye:\n\n🍎 Mac:\n   pwd\n   → Print Working Directory\n   → Example output: /users/malvik\n\n🪟 Windows:\n   cd\n   → Same kaam karta hai\n\n─────────────────────────────────\npwd → /users/malvik\n─────────────────────────────────\n\nFiles aur folders list karne ke liye:\n\n🍎 Mac:     ls\n🪟 Windows: dir\n\n─────────────────────────────────\nls  → folders & files list\ndir → (Windows equivalent)\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "📂 cd — Directory Change Karo",
                    "Kisi folder mein jaane ke liye:\n\n   cd desktop\n   → Desktop folder mein chale jao\n   (Mac aur Windows dono mein same)\n\n─────────────────────────────────\ncd desktop → move into Desktop folder\n─────────────────────────────────\n\nAb desktop ke andar ls ya dir karo.\nMaan lo ek folder dikhta hai: top_folder\n\n   cd top_folder\n   → top_folder mein jaao\n\nPhir andar ls karo → sub_folder_1 dikhega\n\n   cd sub_folder_1\n\n─────────────────────────────────\nDesktop\n└── top_folder\n    └── sub_folder_1\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "⬆️ cd .. — Wapas Upar Jaao",
                    "Ek level upar jaane ke liye:\n\n   cd ..\n   (do dots = parent folder)\n\n─────────────────────────────────\nsub_folder_1 → cd .. → top_folder\ntop_folder   → cd .. → Desktop\n─────────────────────────────────\n\n⚠️  Direct jump nahi kar sakte!\n\nMaan lo tum Desktop par ho aur\nsub_folder_1 mein jaana hai (2 levels neeche).\nYe seedha nahi ho sakta:\n\n   ❌  cd sub_folder_1  → Error!\n\nYe karna padega — step by step:\n\n   ✅  cd top_folder\n   ✅  cd sub_folder_1\n\n─────────────────────────────────\n💡 Ek baar mein sirf ek level\n   move kar sakte ho!\n─────────────────────────────────"
                ),
            ),
            "it_mongo_ch3_m2" to listOf(
                ContentBlock.TextBlock(
                    "🧭 Compass se Import & Export — GUI Tarika\n\nIs module mein hum Compass ka use karke collections import aur export karenge.\n\nYe GUI (graphical) tarika hai — bina terminal ke!\n\nPehle Atlas se connect karna hoga. 🔌\n\n─────────────────────────────────\nAtlas → Connection String → Compass → Connect\n─────────────────────────────────"
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
                    "🔑 URI kya hota hai?",
                    "URI = Uniform Resource Identifier\n\nYe tumhe Atlas cluster se connect karne deta hai.\n\n─────────────────────────────────\nmongodb+srv://username:password@cluster-url/database\n─────────────────────────────────\n\nBreakdown:\n🔐 mongodb+srv://  → Secure connection\n👤 username:password → Login credentials\n🌐 @cluster-url    → Tumhara cluster address\n🗄️ /database       → Database ka naam\n─────────────────────────────────\n\nURI Atlas se milti hai:\nAtlas → Connect → Connect using Compass\n→ Connection string copy karo\n→ Database naam aur password add karo"
                ),
                ContentBlock.ExampleBlock(
                    "📤 mongoexport — Collection Export Karo",
                    "Syntax:\nmongoexport --uri=\"...\" --collection=... --out=...\n\n3 main options:\n📌 --uri        → Atlas cluster connect karna\n📌 --collection → Kaunsi collection export karni\n📌 --out        → File kahan save hogi\n\n─────────────────────────────────\nExample command:\nmongoexport \\\n  --uri=\"mongodb+srv://user:pass@cluster/import_export_db\"\\\n  --collection=import_export_col1 \\\n  --out=import_export_col1.json\n─────────────────────────────────\n\nSteps:\n1️⃣  Terminal open karo\n2️⃣  Desktop mein jaao:  cd Desktop\n3️⃣  Command paste karo → Enter\n\nOutput: \"exported 1 record\" ✅\n\n─────────────────────────────────\nCollection → Export → JSON File (Desktop)\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "📥 mongoimport — Collection Import Karo",
                    "Syntax:\nmongoimport --uri=\"...\" --collection=... --file=...\n\n3 main options:\n📌 --uri        → Connection\n📌 --collection → Jisme data dalna hai\n📌 --file       → Kaunsi JSON file import karni\n\n─────────────────────────────────\nExample command:\nmongoimport \\\n  --uri=\"mongodb+srv://user:pass@cluster/import_export_db\"\\\n  --collection=import_export_col1 \\\n  --file=import_export_col1.json\n─────────────────────────────────\n\nSteps:\n1️⃣  Pehle collection delete karo (test ke liye)\n2️⃣  Terminal mein command run karo\n3️⃣  Compass mein refresh karo\n\n✅ Collection wapas aa gayi with documents!\n\n─────────────────────────────────\nJSON File → mongoimport → Atlas Collection\n─────────────────────────────────\n\n🔥 Ek line mein yaad rakho:\nmongexport  = DB → file\nmongoimport = file → DB"
                ),
            ),
            "it_mongo_ch3_m4" to listOf(
                ContentBlock.TextBlock(
                    "🗂️ Mongodump & Mongorestore — BSON Format\n\nHumne JSON format ke tools dekhe (mongoimport/mongoexport).\nAb hum ek aur tarika dekhenge — BSON format wale tools:\n\n📌 mongodump    → Database export (BSON)\n📌 mongorestore → Database import (BSON)\n\n─────────────────────────────────\nmongoexport / mongoimport → JSON (readable)\nmongodump   / mongorestore → BSON (binary, fast)\n─────────────────────────────────\n\n❓ JSON aur BSON mein kya fark?\n\n📄 JSON — Human readable text format\n   → Analysis ke liye best\n   → Text editor mein open kar sakte ho\n\n⚡ BSON — Binary JSON\n   → Human readable NAHI hota\n   → Speed aur performance ke liye optimized\n   → Databases/clusters ke beech transfer ke liye best"
                ),
                ContentBlock.ExampleBlock(
                    "📤 mongodump — Poora Database Export Karo",
                    "mongodump ka syntax:\nmongodump --uri=\"...\"\n\n💡 Sirf URI kaafi hai!\n   Collection ka naam nahi chahiye —\n   poora database export hota hai.\n\n─────────────────────────────────\nDatabase → mongodump → dump folder\n─────────────────────────────────\n\nSteps:\n1️⃣  Terminal open karo → Desktop par jaao\n    cd Desktop\n\n2️⃣  mongodump command paste karo → Enter\n\n3️⃣  Export complete! ✅\n\nResult:\nDesktop par ek 'dump' folder create hoga:\n\n─────────────────────────────────\ndump/\n└── import_export_db/\n    ├── collection.bson\n    └── collection.metadata.json\n─────────────────────────────────\n\n⚠️  BSON file open karoge to readable\n   nahi hogi — binary format hai!"
                ),
                ContentBlock.ExampleBlock(
                    "📥 mongorestore — Database Wapas Laao",
                    "mongorestore ka syntax:\nmongorestore --uri=\"...\" dump/import_export_db\n\nDo cheezein chahiye:\n📌 URI → cluster connection\n📌 Path → dump folder ka path\n\n─────────────────────────────────\nExample command:\nmongorestore \\\n  --uri=\"mongodb+srv://user:pass@cluster/db\" \\\n  dump/import_export_db\n─────────────────────────────────\n\nSteps:\n1️⃣  Compass mein database delete karo\n    (\"Drop Database\" par click karo)\n\n2️⃣  Terminal mein mongorestore command run\n\n3️⃣  Compass refresh karo\n\n✅ Database wapas aa gaya! 🎉\n\n─────────────────────────────────\ndump folder → mongorestore → Atlas Database\n─────────────────────────────────"
                ),
                ContentBlock.TextBlock(
                    "🔥 Final Clarity — Kab Kya Use Karein?\n\n─────────────────────────────────\nmongoexport  → collection → JSON file\nmongoimport  → JSON file → collection\n\nmongodump    → database  → BSON folder\nmongorestore → BSON folder → database\n─────────────────────────────────\n\n💡 Ek line mein yaad rakho:\n\n📄 JSON  = Readable\n          → Analysis / debugging ke liye\n          → Mongoimport / Mongoexport\n\n⚡ BSON  = Fast\n          → Transfer / backup ke liye\n          → Mongodump / Mongorestore\n\n📚 Aur options chahiye?\n   MongoDB documentation dekho —\n   wahan advanced use cases bhi hain!\n\n✅ Chapter 3 Complete!"
                ),
            ),
            "it_mongo_ch4_m1" to listOf(
                ContentBlock.TextBlock(
                    "🔍 find aur findOne — MongoDB Ka Pehla Query Method\n\nShell se connect karo:\nAtlas → Connect → Connect with MongoDB Shell\nConnection string copy karo → Terminal mein paste karo → Password enter karo.\n\nPhir database check karo:\n   show dbs\n   use sample_training\n   show collections"
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
                    "🖥️ Data Explorer — GUI se Queries Karo\n\nShell ke alawa tum MongoDB Atlas ya Compass ke Data Explorer mein bhi queries run kar sakte ho — bina terminal ke! 🎯\n\nAtlas mein:\nApni collection par navigate karo → Documents tab → Filter box dikhega"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Atlas Data Explorer — Filter Kaise Lagaate Hain",
                    "1️⃣  Atlas mein login karo\n    → Browse Collections\n    → Apni collection select karo\n       (e.g. grades)\n\n2️⃣  Filter box mein key-value pair likho\n    (curly braces mein):\n\n    { \"class_id\": 419 }\n\n3️⃣  Apply par click karo\n\n✅ Sirf class_id 419 ke documents dikhenge!\n\n─────────────────────────────────\nYe bilkul same hai jaise shell mein:\ndb.grades.find({\"class_id\": 419})\n─────────────────────────────────\n\nMultiple conditions:\n{ \"class_id\": 270, \"student_id\": 1 }\n→ Comma se alag karo, Apply karo\n\n📌 Options button se aur bhi milta hai:\n   → Project (fields select karo)\n   → Sort    (order decide karo)\n   → Collation (language rules)"
                ),
                ContentBlock.ExampleBlock(
                    "🧭 Compass Data Explorer — Same Kaam, Same Tarika",
                    "Compass mein bhi bilkul same Data Explorer view hai:\n\n1️⃣  Compass open karo → Atlas se connect karo\n\n2️⃣  Left panel → sample_training database\n    → grades collection par click karo\n\n3️⃣  Documents view khulega\n    → Filter box dikhega\n    → Options: Project, Sort, Collation\n\n4️⃣  Filter daalo:\n    { \"class_id\": 419 }\n    → Apply / Find par click karo\n\n✅ Results wahi honge — GUI tool different\n   lekin query language same!\n\n─────────────────────────────────\nAtlas Data Explorer  →  Filter box\nCompass Data Explorer →  Filter box\nShell               →  db.col.find({})\n\nTeeno mein same JSON query syntax! 🎯\n─────────────────────────────────"
                ),
            ),
            "it_mongo_ch4_m3" to listOf(
                ContentBlock.TextBlock(
                    "⚠️ Case Sensitivity — MongoDB Mein Bahut Zaroori!\n\nMongoDB mein saare objects case sensitive hote hain:\n\n📌 Database name — exact case\n📌 Collection name — exact case\n📌 Method name — exact case\n📌 Field names — exact case\n📌 String values — exact case\n\nEk bhi character galat hua to error! ❌\n\nSaath hi — fields ko double quotes mein likhna good practice hai, aur non-numerical values bhi."
                ),
                ContentBlock.ExampleBlock(
                    "✅ Sahi vs ❌ Galat — Case Sensitivity Examples",
                    "Collection: trips  |  Method: findOne\n\n─────────────────────────────────\n✅  db.trips.findOne()\n    → CORRECT! Sab sahi case mein\n─────────────────────────────────\n\n❌  Db.trips.findOne()\n    → GALAT! 'Db' mein uppercase D\n       db lowercase hona chahiye\n\n❌  db.Trips.findOne()\n    → GALAT! Collection 'trips' hai\n       'Trips' nahi — case matter karta hai\n\n❌  db.trips.FindOne()\n    → GALAT! Method 'findOne' hai\n       'FindOne' nahi —\n       find lowercase, One uppercase O\n─────────────────────────────────\n\n💡 Yaad rakhne ka tarika:\n   db      → hamesha lowercase\n   findOne → find(lower) + One(upper O)\n   Collection name → EXACTLY jo save kiya"
                ),
                ContentBlock.TextBlock(
                    "📝 Best Practices — Queries Likhte Waqt\n\n1️⃣  Fields ko double quotes mein likho:\n    ✅  {\"class_id\": 419}\n    ⚠️  {'class_id': 419}  (single quotes bhi chalte hain)\n\n2️⃣  Non-numerical values bhi quotes mein:\n    ✅  {\"result\": \"Violation Issued\"}\n    ❌  {\"result\": Violation Issued}\n\n3️⃣  Numbers ko quotes ki zarurat nahi:\n    ✅  {\"class_id\": 419}\n    ✅  {\"class_id\": \"419\"}  (ye string treat hoga!)\n\n4️⃣  Hamesha sahi database mein raho:\n    use sample_training → phir query karo\n\n─────────────────────────────────\n🎯 Rule of thumb:\n   Strings → quotes mein\n   Numbers → bina quotes\n   Fields  → hamesha double quotes mein\n─────────────────────────────────"
                ),
            ),
            "it_mongo_ch4_m4" to listOf(
                ContentBlock.TextBlock(
                    "🗄️ Databases & Collections Create/Delete Karna\n\nTeen jagah se kar sakte ho:\n📌 Atlas (GUI — browser)\n📌 Compass (GUI — desktop app)\n📌 Shell (Terminal/CMD — commands)\n\nSabse pehle Atlas se shuru karte hain! 🚀"
                ),
                ContentBlock.ExampleBlock(
                    "🌐 Atlas aur Compass — GUI Tarika",
                    "Atlas mein:\n1️⃣  Browse Collections par click karo\n2️⃣  \"Create Database\" par click karo\n3️⃣  Database naam: test_db\n    Collection naam: test_collection\n4️⃣  Create!\n\n💡 Capped Collection option:\n   → Tick karo to max size set hoti hai\n   → Space full hone par purane docs\n      overwrite ho jaate hain\n   → Hum ise unticked chhodte hain\n\nDelete karna:\n   → Trash icon par click karo\n   → Collection ya Database dono delete ho sakte\n   ⚠️  Agar database mein sirf ek collection hai\n      to collection delete karne par\n      database bhi delete ho jaata hai!\n\n─────────────────────────────────\nCompass mein bhi almost same process:\nCollection pe hover karo → Trash icon\n─────────────────────────────────"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Shell — Commands se Create/Delete Karo",
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
                    "💻 Sirf tags Field Project Karo",
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
                    "💻 ✅ \$elemMatch — Sahi Tarika",
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
                    "💻 ❌ Galat Tarika",
                    "// ❌ Ye kaam NAHI karega\ndb.inspections.find({\n  zip: 11427\n})\n// Result: empty (koi document nahi)\n\n// Kyun? zip top-level pe exist nahi karta\n// Woh address.zip hai!"
                ),
                ContentBlock.TextBlock(
                    "✅ Sahi Tarika — Dot Notation\n\nEmbedded fields ko query karne ka sahi tarika:\n  \"parent.child\"\n\nDot (.) se parent aur child field separate hote hain.\nPoori string quotes mein honi chahiye!"
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
                    "💻 _id Remove Karna",
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
            ),
            "it_mongo_ch4_m17" to listOf(
                ContentBlock.TextBlock(
                    "📥 MongoDB Insert Documents\n\nIs lecture mein hum documents ko collection mein insert karna sikhenge.\n\n🚀 Shell Se Start\nHum sample_training database use karenge.\n\nMongoDB mein collection implicitly create hoti hai — agar collection exist nahi karta tab bhi insert kar sakte ho.\nMongoDB automatically collection create kar deta hai.\ncreateCollection() method ki zarurat nahi!"
                ),
                ContentBlock.ExampleBlock(
                    "💻 Insert Method Syntax",
                    "// Single document insert:\ndb.collection.insert(document)\n\n// Multiple documents insert:\ndb.collection.insert([\n  doc1,\n  doc2\n])"
                ),
                ContentBlock.TextBlock(
                    "📌 Insert Method Parameters\n\n1️⃣ First Parameter\n  ek document\n  ya documents ka array\n  Documents JSON structure follow karte hain.\n\n2️⃣ Second Parameter (optional — is lecture mein skip)\n  writeConcern\n  ordered\n  Agar omit karo to default behavior follow hoga."
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
                    "⚠️ Important Concepts\n\n✅ Same Query Dobara Run Karna\nAgar same insert query dobara run karo → ye phir bhi insert ho jayega!\nKyunki dono documents ka _id different hoga.\n\n✅ Same field values allowed hain\n❌ Bas _id unique hona chahiye\n\n⚠️ Duplicate Key Error\nAgar copied document mein same _id ho:\n→ Error aayega: Duplicate Key Error\n\n✅ MongoDB is Schemaless\nDifferent structure ke documents same collection mein insert kar sakte ho."
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
                    "🖥️ MongoDB Atlas Insert — Steps\n\n1️⃣ Collections pe click karo → test_collection open karo\n2️⃣ Insert Document button pe click karo\n3️⃣ _id auto generate hoti hai (unique)\n4️⃣ Field-Value pair add karo\n5️⃣ Data type specify kar sakte ho:\n   String / Number / Boolean / Object / Array\n\n🔹 Embedded Document add karna:\n   Object type select karo → phir key-value pairs\n\n🔹 Array add karna:\n   Array type select karo → phir elements\n\n🔹 JSON View dekhna:\n   Curly braces icon pe click karo\n\n✅ MongoDB Compass mein bhi same process hota hai."
                ),
                ContentBlock.TextBlock(
                    "🧠 Important Concepts Recap\n\n  insert() → Documents collection mein insert karta hai\n\n  Implicit Collection Creation\n  Agar collection exist nahi karta → MongoDB automatically create kar deta hai\n\n  _id field:\n    ✅ Automatically generate hoti hai\n    ✅ Unique hoti hai\n    ✅ Custom bhi de sakte ho\n\n  ⚠️ Duplicate Key Error → Same _id dobara insert karne par\n\n  ✅ Schemaless Nature → Different structure ke documents same collection mein allowed"
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
                    "🚀 Setup — Collection Check Karo",
                    "// sample_training database mein hain\n// test_collection ke documents dekho:\ndb.test_collection.find()"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 Example 1 — deleteOne()",
                    "// name = \"Tom Hanks\" wala ek document delete karo:\ndb.test_collection.deleteOne({\n  name: \"Tom Hanks\"\n})\n\n// ⚠️ Note: 'd' lowercase hai, 'O' uppercase hai\n\n// Result:\n// acknowledged: true\n// deletedCount: 1"
                ),
                ContentBlock.ExampleBlock(
                    "🔍 deleteOne() Result Verify Karo",
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
                    "🔍 Example 3 — Embedded Field Se Delete",
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
        )

        private val questions = mapOf(
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
                    explanation = "Delete filter aur find() filter identical hain — same syntax, same operators ($gt, $lt, dot notation, $and, etc.). Difference sirf result mein hai: find() documents return karta hai, deleteOne()/deleteMany() matching documents delete karta hai. Isliye ek common pattern hai: pehle find() se verify karo, phir same filter se delete karo."
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
                    questionText = "MongoDB Atlas free tier mein kitna storage milta hai?",
                    options = listOf(
                        Option("a", "256 MB"),
                        Option("b", "512 MB"),
                        Option("c", "1 GB"),
                        Option("d", "5 GB")
                    ),
                    correctOptionId = "b",
                    explanation = "MongoDB Atlas ka M0 free tier 512 MB storage provide karta hai — jo training aur beginners ke liye bilkul kaafi hai. Koi credit card bhi nahi chahiye!"
                ),
                Question(
                    id = "ch2mq2_2",
                    questionText = "Network Access mein 0.0.0.0/0 add karne ka kya matlab hai?",
                    options = listOf(
                        Option("a", "Sirf localhost se access allowed hai"),
                        Option("b", "Access completely block ho jaata hai"),
                        Option("c", "Kisi bhi IP address se cluster access allowed hai"),
                        Option("d", "Sirf Atlas servers se access allowed hai")
                    ),
                    correctOptionId = "c",
                    explanation = "0.0.0.0/0 matlab hai ki koi bhi IP address cluster ko access kar sakta hai. Ye training ke liye convenient hai, lekin production mein specific IPs whitelist karni chahiye."
                ),
                Question(
                    id = "ch2mq2_3",
                    questionText = "Database user create karte waqt kaunse privileges dene chahiye?",
                    options = listOf(
                        Option("a", "Read Only"),
                        Option("b", "Write Only"),
                        Option("c", "No Privileges"),
                        Option("d", "Atlas Admin")
                    ),
                    correctOptionId = "d",
                    explanation = "Training ke liye database user ko Atlas Admin privileges deni chahiye. Isse tum cluster par sab kuch kar sakte ho — data read, write, aur manage."
                ),
            ),
            "it_mongo_ch2_m1" to listOf(
                Question(
                    id = "ch2mq1_1",
                    questionText = "MQL ka full form kya hai?",
                    options = listOf(
                        Option("a", "Mongo Queue Language"),
                        Option("b", "Multiple Query Language"),
                        Option("c", "Modern Query Language"),
                        Option("d", "Mongo Query Language")
                    ),
                    correctOptionId = "d",
                    explanation = "MQL ka full form hai Mongo Query Language. Ye MongoDB ke saath communicate karne ka primary tarika hai — simple, imperative, aur easy to learn!"
                ),
                Question(
                    id = "ch2mq1_2",
                    questionText = "MQL kis type ki language hai?",
                    options = listOf(
                        Option("a", "Declarative — batao kaise karna hai"),
                        Option("b", "Imperative — batao kya karna hai"),
                        Option("c", "Functional — pure functions use karo"),
                        Option("d", "Object-oriented — classes use karo")
                    ),
                    correctOptionId = "b",
                    explanation = "MQL ek imperative language hai — tum MongoDB ko directly batate ho ki kya karna hai. Tumhe ye nahi batana ki internally kaise kare, bas result batao."
                ),
                Question(
                    id = "ch2mq1_3",
                    questionText = "Aggregation Pipeline kab use ki jaati hai?",
                    options = listOf(
                        Option("a", "Sirf documents insert karne ke liye"),
                        Option("b", "Single simple queries ke liye"),
                        Option("c", "Complex multi-step queries ke liye jaise filter + group + sort"),
                        Option("d", "Database delete karne ke liye")
                    ),
                    correctOptionId = "c",
                    explanation = "Aggregation Pipeline complex queries ke liye use hoti hai jahan multiple operations karne hon — jaise pehle filter karo, phir group karo. Har operation ek alag stage mein hoti hai."
                ),
            ),
            "it_mongo_ch1_m6" to listOf(
                Question(
                    id = "mq6_1",
                    questionText = "SQL mein multiple tables se data fetch karne ke liye kya use karna padta hai?",
                    options = listOf(
                        Option("a", "Shard Keys"),
                        Option("b", "Replica Sets"),
                        Option("c", "JOIN operations"),
                        Option("d", "Indexes")
                    ),
                    correctOptionId = "c",
                    explanation = "SQL mein jab multiple tables se data chahiye hota hai to JOIN operations use karne padte hain. Ye complex aur slow ho sakte hain jab zyada tables involved hon. MongoDB mein yahi data ek document mein embedded hota hai."
                ),
                Question(
                    id = "mq6_2",
                    questionText = "MongoDB ke schemaless hone ka main faayda kya hai?",
                    options = listOf(
                        Option("a", "Data automatically delete hota rehta hai"),
                        Option("b", "Queries hamesha slow ho jaati hain"),
                        Option("c", "Naye fields add karna aur data structure change karna bahut easy hota hai"),
                        Option("d", "Sirf ek type ka data store ho sakta hai")
                    ),
                    correctOptionId = "c",
                    explanation = "Schemaless hone ka matlab hai koi fixed structure nahi — naye fields add karo, purane hataao, format badlo. Koi table alter nahi, koi migration nahi. SQL mein yahi kaam kaafi complex hota hai."
                ),
                Question(
                    id = "mq6_3",
                    questionText = "MongoDB mein horizontal scaling ka matlab kya hai?",
                    options = listOf(
                        Option("a", "Ek hi server ka RAM aur CPU badhana"),
                        Option("b", "Database ko compress karna"),
                        Option("c", "Cluster mein aur servers add karke data distribute karna"),
                        Option("d", "Data delete karke space banana")
                    ),
                    correctOptionId = "c",
                    explanation = "Horizontal scaling mein tum cluster mein aur servers (instances) add karte ho. Data in servers mein distribute ho jaata hai, isliye MongoDB easily big data handle kar sakta hai."
                ),
            ),
            "it_mongo_ch1_m5" to listOf(
                Question(
                    id = "mq5_1",
                    questionText = "Ek Replica Set mein kitne instances (machines) hote hain?",
                    options = listOf(
                        Option("a", "1"),
                        Option("b", "2"),
                        Option("c", "3"),
                        Option("d", "5")
                    ),
                    correctOptionId = "c",
                    explanation = "Ek standard Replica Set 3 instances se banta hai — ek Primary aur do Secondary. Teeno par same data hota hai, isliye koi bhi ek fail ho to baaki do data safe rakhte hain."
                ),
                Question(
                    id = "mq5_2",
                    questionText = "Sharded Cluster mein Mongos ka kya kaam hai?",
                    options = listOf(
                        Option("a", "Data store karna"),
                        Option("b", "Cluster ka metadata store karna"),
                        Option("c", "Application aur shards ke beech router ka kaam karna"),
                        Option("d", "Backup lena")
                    ),
                    correctOptionId = "c",
                    explanation = "Mongos ek query router hai — ye application se query receive karta hai aur decide karta hai ki wo query kis shard par bhejni hai."
                ),
                Question(
                    id = "mq5_3",
                    questionText = "Sharding ka primary faayda kya hai?",
                    options = listOf(
                        Option("a", "Data automatically delete hota rehta hai"),
                        Option("b", "Queries slow ho jaati hain"),
                        Option("c", "Data encrypt ho jaata hai"),
                        Option("d", "Data multiple servers mein distribute ho jaata hai — scalability badhti hai")
                    ),
                    correctOptionId = "d",
                    explanation = "Sharding se data multiple servers (shards) mein split hota hai. Jab data badhta hai, aur shards add karke storage aur performance dono scale kar sakte ho."
                ),
            ),
            "it_mongo_ch1_m4" to listOf(
                Question(
                    id = "mq4_1",
                    questionText = "MongoDB Atlas kahan host hota hai?",
                    options = listOf(
                        Option("a", "Sirf AWS (Amazon) par"),
                        Option("b", "Sirf tumhare local server par"),
                        Option("c", "AWS, Microsoft Azure ya Google Cloud par"),
                        Option("d", "Sirf Microsoft Azure par")
                    ),
                    correctOptionId = "c",
                    explanation = "MongoDB Atlas teen major cloud providers par available hai — AWS, Microsoft Azure, aur Google Cloud Platform. Tum apni marzi ka provider choose kar sakte ho."
                ),
                Question(
                    id = "mq4_2",
                    questionText = "MongoDB Compass kya hai?",
                    options = listOf(
                        Option("a", "Ek command line shell tool"),
                        Option("b", "Ek fully managed cloud database"),
                        Option("c", "Mobile apps banane ka framework"),
                        Option("d", "Ek graphical user interface (GUI) MongoDB ke liye")
                    ),
                    correctOptionId = "d",
                    explanation = "MongoDB Compass ek GUI tool hai jo tumhe click-based interface se MongoDB ke saath kaam karne deta hai — terminal ya code likhne ki zaroorat nahi!"
                ),
                Question(
                    id = "mq4_3",
                    questionText = "MongoDB Drivers ka main kaam kya hai?",
                    options = listOf(
                        Option("a", "Data ko charts mein visualize karna"),
                        Option("b", "Mobile apps develop karna"),
                        Option("c", "Different programming languages mein MongoDB queries likhna"),
                        Option("d", "On-premises server setup karna")
                    ),
                    correctOptionId = "c",
                    explanation = "MongoDB Drivers tumhe allow karte hain ki tum apni pasandida programming language (JavaScript, Python, Java, etc.) mein MongoDB queries likh sako."
                ),
            ),
            "it_mongo_ch1_m3" to listOf(
                Question(
                    id = "mq3_1",
                    questionText = "JSON document mein keys kaise likhni chahiye?",
                    options = listOf(
                        Option("a", "Single quotes mein — 'name'"),
                        Option("b", "Bina quotes ke — name"),
                        Option("c", "Double quotes mein — \"name\""),
                        Option("d", "Square brackets mein — [name]")
                    ),
                    correctOptionId = "c",
                    explanation = "JSON mein keys hamesha double quotes \" \" mein likhni chahiye. Single quotes valid nahi hote JSON mein."
                ),
                Question(
                    id = "mq3_2",
                    questionText = "MongoDB ki _id field ke baare mein kya sach hai?",
                    options = listOf(
                        Option("a", "Ise hamesha manually specify karna padta hai"),
                        Option("b", "Ye ek optional field hai"),
                        Option("c", "Agar specify na karo toh MongoDB automatically generate kar deta hai"),
                        Option("d", "Ye field sirf numbers store kar sakti hai")
                    ),
                    correctOptionId = "c",
                    explanation = "_id ek unique identifier hai jo hamesha populated hoti hai. Agar tum specify nahi karte, MongoDB automatically ek unique value generate kar deta hai."
                ),
                Question(
                    id = "mq3_3",
                    questionText = "MongoDB documents mein arrays kaise represent hote hain?",
                    options = listOf(
                        Option("a", "Curly braces { } se"),
                        Option("b", "Round brackets ( ) se"),
                        Option("c", "Double quotes \" \" se"),
                        Option("d", "Square brackets [ ] se")
                    ),
                    correctOptionId = "d",
                    explanation = "Arrays square brackets [ ] se represent hote hain. Example: \"phone\": [\"9999\", \"8888\"] — ek field mein multiple values."
                ),
            ),
            "it_mongo_ch1_m2" to listOf(
                Question(
                    id = "mq2_1",
                    questionText = "MongoDB mein data kis order mein organize hota hai?",
                    options = listOf(
                        Option("a", "Documents → Collections → Database"),
                        Option("b", "Database → Collections → Documents"),
                        Option("c", "Collections → Database → Documents"),
                        Option("d", "Tables → Rows → Database")
                    ),
                    correctOptionId = "b",
                    explanation = "Sahi order hai: Database ke andar Collections hoti hain, aur Collections ke andar Documents hote hain."
                ),
                Question(
                    id = "mq2_2",
                    questionText = "Polymorphic documents ka matlab kya hai?",
                    options = listOf(
                        Option("a", "Har document bilkul same structure ka hona chahiye"),
                        Option("b", "Documents sirf numbers store kar sakte hain"),
                        Option("c", "Same collection ke documents ka structure alag ho sakta hai"),
                        Option("d", "Ek collection mein sirf ek document ho sakta hai")
                    ),
                    correctOptionId = "c",
                    explanation = "Polymorphic matlab flexible structure — same collection ke alag-alag documents mein alag fields ho sakti hain. Koi fixed schema nahi hoti!"
                ),
                Question(
                    id = "mq2_3",
                    questionText = "SQL mein naya column add karne par kya problem aati hai?",
                    options = listOf(
                        Option("a", "Database automatically delete ho jaata hai"),
                        Option("b", "Jahan data missing hai wahan NULL values store honti hain"),
                        Option("c", "Sabhi rows mein automatically value fill ho jaati hai"),
                        Option("d", "Naya column sirf kuch rows mein add hota hai")
                    ),
                    correctOptionId = "b",
                    explanation = "SQL mein naya column add karne par jahan data available nahi hota wahan NULL values aati hain, aur table constraints aur related tables ka bhi dhyan rakhna padta hai."
                ),
            ),
            "it_mongo_ch1_m1" to listOf(
                Question(
                    id = "mq1",
                    questionText = "SQL databases data ko kaise store karte hain?",
                    options = listOf(
                        Option("a", "JSON documents mein"),
                        Option("b", "Tables (relational format) mein"),
                        Option("c", "Key-value pairs mein"),
                        Option("d", "Graph nodes mein")
                    ),
                    correctOptionId = "b",
                    explanation = "SQL databases relational model use karte hain — data tables mein store hota hai aur tables ke beech predefined relationships hote hain."
                ),
                Question(
                    id = "mq2",
                    questionText = "MongoDB kaunse type ka NoSQL database hai?",
                    options = listOf(
                        Option("a", "Key-value database"),
                        Option("b", "Graph database"),
                        Option("c", "Wide column database"),
                        Option("d", "Document database")
                    ),
                    correctOptionId = "d",
                    explanation = "MongoDB ek document database hai jisme data JSON-jaisi documents ke form mein store hota hai, jo collections ke andar rakhe jaate hain."
                ),
                Question(
                    id = "mq3",
                    questionText = "MongoDB mein documents kahan store hote hain?",
                    options = listOf(
                        Option("a", "Tables mein"),
                        Option("b", "Rows mein"),
                        Option("c", "Collections mein"),
                        Option("d", "Spreadsheets mein")
                    ),
                    correctOptionId = "c",
                    explanation = "MongoDB mein documents, collections ke andar store hote hain. Ye SQL ki tables jaisi hoti hain, lekin ye schema-flexible hoti hain."
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
        )
        // endregion
    }
}
