package com.example.myapp.data.repository

import com.example.myapp.data.model.*

class HardcodedContentRepository : ContentRepository {

    override fun getClasses(): List<SchoolClass> = classes

    override fun getSubjects(): List<Subject> = subjects

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

        private val subjects = listOf(
            Subject(id = "maths", displayName = "Mathematics", isEnabled = true),
            Subject(id = "physics", displayName = "Physics", isEnabled = false),
            Subject(id = "chemistry", displayName = "Chemistry", isEnabled = false),
            Subject(id = "geography", displayName = "Geography", isEnabled = false),
            Subject(id = "history", displayName = "History", isEnabled = false),
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
        )
        // endregion

        // region Class 6 - Number System modules + content
        private val modules = mapOf(
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
        )

        private val questions = mapOf(
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
