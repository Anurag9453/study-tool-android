#!/usr/bin/env python3
"""Insert ch6 modules m9-m22 into HardcodedContentRepository.kt"""

REPO = "/Users/anurag.s/Downloads/Android/app/src/main/java/com/example/myapp/data/repository/HardcodedContentRepository.kt"

with open(REPO, "r") as f:
    content = f.read()

# ─────────────────────────────────────────────────────────────────────────────
# 1. MODULE LIST ENTRIES (insert after m8 module entry)
# ─────────────────────────────────────────────────────────────────────────────
MODULE_ANCHOR = '                Module("it_mongo_ch6_m8", "it_mongo_ch6", "Comparison Operators", 8),'
MODULE_INSERT = '''                Module("it_mongo_ch6_m9",  "it_mongo_ch6", "Array Expression Operators", 9),
                Module("it_mongo_ch6_m10", "it_mongo_ch6", "Conditional Operators", 10),
                Module("it_mongo_ch6_m11", "it_mongo_ch6", "Assignment: Arrays & Conditions", 11),
                Module("it_mongo_ch6_m12", "it_mongo_ch6", "\\$addFields Stage", 12),
                Module("it_mongo_ch6_m13", "it_mongo_ch6", "\\$sort, \\$count, \\$limit, \\$skip", 13),
                Module("it_mongo_ch6_m14", "it_mongo_ch6", "Assignment: addFields & Sort", 14),
                Module("it_mongo_ch6_m15", "it_mongo_ch6", "\\$group Stage", 15),
                Module("it_mongo_ch6_m16", "it_mongo_ch6", "\\$bucket and \\$bucketAuto", 16),
                Module("it_mongo_ch6_m17", "it_mongo_ch6", "\\$facet Stage", 17),
                Module("it_mongo_ch6_m18", "it_mongo_ch6", "\\$sortByCount Stage", 18),
                Module("it_mongo_ch6_m19", "it_mongo_ch6", "Assignment: Group, Sort & Bucket", 19),
                Module("it_mongo_ch6_m20", "it_mongo_ch6", "\\$unwind Stage", 20),
                Module("it_mongo_ch6_m21", "it_mongo_ch6", "\\$out Stage", 21),
                Module("it_mongo_ch6_m22", "it_mongo_ch6", "Combining Pipeline Stages", 22),'''

assert MODULE_ANCHOR in content, "Module anchor not found!"
content = content.replace(MODULE_ANCHOR, MODULE_ANCHOR + "\n" + MODULE_INSERT, 1)

# ─────────────────────────────────────────────────────────────────────────────
# 2. CONTENT BLOCKS (insert after ch6_m8 content block closing ),)
# ─────────────────────────────────────────────────────────────────────────────
CONTENT_ANCHOR = '''                ContentBlock.TextBlock(
                    "\\\\uD83D\\\\uDCDA Lecture Recap\\n\\n  \\u2705 Comparison operators: \\$gt, \\$gte, \\$lt, \\$lte, \\$eq, \\$ne\\n  \\u2705 MQL syntax: { field: { \\$gt: value } }\\n  \\u2705 Expression syntax: { \\$gt: [expr1, expr2] } \\u2014 array-based\\n  \\u2705 \\$match mein expression syntax \\u2192 \\$expr required\\n  \\u2705 \\$project mein expression syntax \\u2192 directly (no \\$expr)\\n  \\u2705 \\$project mein query syntax \\u2192 ERROR\\n  \\u2705 \\$project mein comparison \\u2192 true/false boolean flag\\n\\n\\uD83D\\uDCA1 Key: \\$project sirf expression syntax; \\$match dono (with/without \\$expr)!"
                ),
            ),'''

# The actual anchor string in the file (using the raw text from the file)
CONTENT_ANCHOR_RAW = '            ),\n        ) }'

# Let me use a different approach - find the m8 content block ending
# The m8 content block section ends with:  ),\n        ) }
# which is unique since it ends the entire contentBlocks map
# Actually let me search for the specific last TextBlock of m8

CONTENT_END_ANCHOR = '\\uD83D\\uDCA1 Key: \\$project sirf expression syntax; \\$match dono (with/without \\$expr)!"\n                ),\n            ),\n        ) }'

NEW_CONTENT_BLOCKS = r'''
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
            ),'''

# Anchor: the closing of m8 content block section
CONTENT_END_MARKER = '\\uD83D\\uDCA1 Key: \\$project sirf expression syntax; \\$match dono (with/without \\$expr)!"\n                ),\n            ),\n        ) }'

assert CONTENT_END_MARKER in content, f"Content anchor not found!\nLooking for: {repr(CONTENT_END_MARKER)}"

REPLACEMENT = '\\uD83D\\uDCA1 Key: \\$project sirf expression syntax; \\$match dono (with/without \\$expr)!"\n                ),\n            ),' + NEW_CONTENT_BLOCKS + '''
        ) }'''

content = content.replace(
    '\\uD83D\\uDCA1 Key: \\$project sirf expression syntax; \\$match dono (with/without \\$expr)!"\n                ),\n            ),\n        ) }',
    '\\uD83D\\uDCA1 Key: \\$project sirf expression syntax; \\$match dono (with/without \\$expr)!"\n                ),\n            ),' + NEW_CONTENT_BLOCKS + '\n        ) }',
    1
)

# ─────────────────────────────────────────────────────────────────────────────
# 3. QUESTIONS (insert after ch6_m8 questions closing ),)
# ─────────────────────────────────────────────────────────────────────────────
NEW_QUESTIONS = r'''
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
            ),'''

# Anchor: end of ch6_m8 questions section
QUESTIONS_END_MARKER = '''            "it_mongo_ch6_m8" to listOf(
                Question(
                    id = "ch6m8_1",'''

# Find the closing ), of ch6_m8 questions
# We need: after ch6m8_3 explanation closes
Q_END_ANCHOR = '                    explanation = "Comparison expression operators (jaise \\$gt, \\$lt, \\$eq) \\$project mein use karne par boolean true/false return karte hain. Isliye ye boolean flag fields create karne ke kaam aate hain — jaise over_100_flag: true/false."\n                ),\n            ),'

assert Q_END_ANCHOR in content, f"Questions anchor not found!\n{repr(Q_END_ANCHOR[:200])}"

content = content.replace(
    '                    explanation = "Comparison expression operators (jaise \\$gt, \\$lt, \\$eq) \\$project mein use karne par boolean true/false return karte hain. Isliye ye boolean flag fields create karne ke kaam aate hain — jaise over_100_flag: true/false."\n                ),\n            ),',
    '                    explanation = "Comparison expression operators (jaise \\$gt, \\$lt, \\$eq) \\$project mein use karne par boolean true/false return karte hain. Isliye ye boolean flag fields create karne ke kaam aate hain — jaise over_100_flag: true/false."\n                ),\n            ),' + NEW_QUESTIONS,
    1
)

with open(REPO, "w") as f:
    f.write(content)

print("Done! File written successfully.")
print(f"File size: {len(content)} bytes")