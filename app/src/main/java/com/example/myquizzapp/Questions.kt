package com.example.myquizzapp


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Questions : AppCompatActivity() {

    private lateinit var questionTextView: TextView
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    private val questions = arrayOf(
        "Nelson Mandela was the president in 1994.",
        "The Great Wall of China is in Japan.",
        "World War II ended in 1945.",
        "Julius Caesar was a Roman Emperor.",
        "The Berlin Wall fell in 1989."
    )

    private val correctAnswers = booleanArrayOf(true, false, false, true, true) // Store the correct answers
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)  // Ensure this matches your XML file name

        // Initialize views
        questionTextView = findViewById(R.id.question_text_view)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)

        // Display the first question
        displayQuestion()

        // Set click listeners for the buttons
        trueButton.setOnClickListener {
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            checkAnswer(false)
        }
        nextButton.setOnClickListener {
            nextQuestion()
        }
    }

    private fun displayQuestion() {
        questionTextView.text = questions[currentQuestionIndex]
        trueButton.isEnabled = true
        falseButton.isEnabled = true
        nextButton.isEnabled = false // Disable until an answer is given
    }

    private fun checkAnswer(answer: Boolean) {
        if (answer == correctAnswers[currentQuestionIndex]) {
            score++
        }
        nextButton.isEnabled = true //enable next button
        trueButton.isEnabled = false
        falseButton.isEnabled = false
    }

    private fun nextQuestion() {
        currentQuestionIndex++
        if (currentQuestionIndex < questions.size) {
            displayQuestion()
        } else {
            // Quiz is over, display the score and message
            val message = if (score >= 3) {
                "Great Job! Your score is $score out of ${questions.size}."
            } else {
                "Try Again. Your score is $score out of ${questions.size}."
            }
            questionTextView.text = message
            trueButton.isEnabled = false
            falseButton.isEnabled = false
            nextButton.isEnabled = false
        }
    }
}
