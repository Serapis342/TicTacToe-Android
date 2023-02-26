package com.serapis.tictactoe

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION", "SpellCheckingInspection")
class MainActivity : AppCompatActivity() {
    private var dpHeight:Int = 0
    private var dpWidth:Int = 0
    private var player:Boolean = true
    private val gameField = Array(3) {CharArray(3)}
    private var handler: Byte = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P)
            window.attributes.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES
        setContentView(R.layout.activity_main)

        val newGame = findViewById<ImageButton>(R.id.newGame)
        val displayMetrics = resources.displayMetrics
        dpHeight = displayMetrics.heightPixels
        dpWidth = displayMetrics.widthPixels

        newGame.visibility = View.INVISIBLE
        resizeLayout()
        newOnClickListener()
    }

    private fun newOnClickListener() {
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val newGame = findViewById<ImageButton>(R.id.newGame)

        button1.setOnClickListener {button1.text = getPlayer(1).toString(); checkForWin(); button1.setOnClickListener(null)}
        button2.setOnClickListener {button2.text = getPlayer(2).toString(); checkForWin(); button2.setOnClickListener(null)}
        button3.setOnClickListener {button3.text = getPlayer(3).toString(); checkForWin(); button3.setOnClickListener(null)}
        button4.setOnClickListener {button4.text = getPlayer(4).toString(); checkForWin(); button4.setOnClickListener(null)}
        button5.setOnClickListener {button5.text = getPlayer(5).toString(); checkForWin(); button5.setOnClickListener(null)}
        button6.setOnClickListener {button6.text = getPlayer(6).toString(); checkForWin(); button6.setOnClickListener(null)}
        button7.setOnClickListener {button7.text = getPlayer(7).toString(); checkForWin(); button7.setOnClickListener(null)}
        button8.setOnClickListener {button8.text = getPlayer(8).toString(); checkForWin(); button8.setOnClickListener(null)}
        button9.setOnClickListener {button9.text = getPlayer(9).toString(); checkForWin(); button9.setOnClickListener(null)}
        newGame.setOnClickListener {val intent = intent; finish(); startActivity(intent)}
    }

    private fun getPlayer(button: Byte): Char{
        val gameView = findViewById<TextView>(R.id.gameView)
        val resources = this.resources

        return if (player) {
            updateGamefield(button, 'X')
            gameView.text = resources.getString(R.string.turn_o)
            player = false
            'X'
        }else{
            updateGamefield(button, 'O')
            gameView.text = resources.getString(R.string.turn_x)
            player = true
            'O'
        }
    }

    private fun resizeLayout() {
        val relativeLayout = findViewById<RelativeLayout>(R.id.relativeLayout)
        val tictactoeView = findViewById<TextView>(R.id.tictactoe_view)
        val gameView = findViewById<TextView>(R.id.gameView)
        val space1 = findViewById<Space>(R.id.space1)
        val space2 = findViewById<Space>(R.id.space2)
        val space3 = findViewById<Space>(R.id.space3)
        val space4 = findViewById<Space>(R.id.space4)
        val space5 = findViewById<Space>(R.id.space5)
        val space6 = findViewById<Space>(R.id.space6)
        val space7 = findViewById<Space>(R.id.space7)
        val space8 = findViewById<Space>(R.id.space8)
        val space9 = findViewById<Space>(R.id.space9)
        val space10 = findViewById<Space>(R.id.space10)
        val space11 = findViewById<Space>(R.id.space11)
        val space12 = findViewById<Space>(R.id.space12)
        val row1 = findViewById<TableRow>(R.id.row1)
        val row2 = findViewById<TableRow>(R.id.row2)
        val row3 = findViewById<TableRow>(R.id.row3)
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)
        val newGame = findViewById<ImageButton>(R.id.newGame)

        val relativeLayoutParams = relativeLayout.layoutParams
        val tictactoeViewParams = tictactoeView.layoutParams
        val gameViewParams = gameView.layoutParams
        val space1Params = space1.layoutParams
        val space2Params = space2.layoutParams
        val space3Params = space3.layoutParams
        val space4Params = space4.layoutParams
        val space5Params = space5.layoutParams
        val space6Params = space6.layoutParams
        val space7Params = space7.layoutParams
        val space8Params = space8.layoutParams
        val space9Params = space9.layoutParams
        val space10Params = space10.layoutParams
        val space11Params = space11.layoutParams
        val space12Params = space12.layoutParams
        val row1Params = row1.layoutParams
        val row2Params = row2.layoutParams
        val row3Params = row3.layoutParams
        val button1Params = button1.layoutParams
        val button2Params = button2.layoutParams
        val button3Params = button3.layoutParams
        val button4Params = button4.layoutParams
        val button5Params = button5.layoutParams
        val button6Params = button6.layoutParams
        val button7Params = button7.layoutParams
        val button8Params = button8.layoutParams
        val button9Params = button9.layoutParams
        val newGameParams = newGame.layoutParams

        relativeLayoutParams.height = calcHeight(640f)
        relativeLayoutParams.width = calcWidth(360f)
        tictactoeViewParams.height = calcHeight(85f)
        gameViewParams.height = calcHeight(42.5f)
        space1Params.height = calcHeight(77.5f)
        space2Params.width = calcWidth(49f)
        space3Params.width = calcWidth(10f)
        space4Params.width = calcWidth(10f)
        space5Params.width = calcWidth(49f)
        space6Params.width = calcWidth(10f)
        space7Params.width = calcWidth(10f)
        space8Params.width = calcWidth(49f)
        space9Params.width = calcWidth(10f)
        space10Params.width = calcWidth(10f)
        space11Params.height = calcHeight(90f)
        space12Params.width = calcWidth(320f)
        row1Params.height = calcHeight(88f)
        row2Params.height = calcHeight(88f)
        row3Params.height = calcHeight(88f)
        button1Params.height = calcHeight(80f)
        button1Params.width = calcWidth(80f)
        button2Params.height = calcHeight(80f)
        button2Params.width = calcWidth(80f)
        button3Params.height = calcHeight(80f)
        button3Params.width = calcWidth(80f)
        button4Params.height = calcHeight(80f)
        button4Params.width = calcWidth(80f)
        button5Params.height = calcHeight(80f)
        button5Params.width = calcWidth(80f)
        button6Params.height = calcHeight(80f)
        button6Params.width = calcWidth(80f)
        button7Params.height = calcHeight(80f)
        button7Params.width = calcWidth(80f)
        button8Params.height = calcHeight(80f)
        button8Params.width = calcWidth(80f)
        button9Params.height = calcHeight(80f)
        button9Params.width = calcWidth(80f)
        newGameParams.width = calcWidth(40f)
    }

    private fun calcHeight(value: Float): Int {
        val designHeight = 640
        return (dpHeight * (value / designHeight)).toInt()
    }

    private fun calcWidth(value: Float): Int {
        val designWidth = 360
        return (dpWidth * (value / designWidth)).toInt()
    }

    @Suppress("DEPRECATED_IDENTITY_EQUALS")
    private fun checkForWin() {
        var privateHandler = false

        for (i in 0..2) {
            if (gameField[0][i] === 'X' && gameField[1][i] === 'X' && gameField[2][i] === 'X') {
                showWinner('X')
                privateHandler = true
            } else if (gameField[i][0] === 'X' && gameField[i][1] === 'X' && gameField[i][2] === 'X') {
                showWinner('X')
                privateHandler = true
            }
        }
        if (gameField[2][0] === 'X' && gameField[1][1] === 'X' && gameField[0][2] === 'X' ||
            gameField[0][0] === 'X' && gameField[1][1] === 'X' && gameField[2][2] === 'X'
        ) {
            showWinner('X')
            privateHandler = true
        }

        for (i in 0..2) {
            if (gameField[0][i] === 'O' && gameField[1][i] === 'O' && gameField[2][i] === 'O') {
                showWinner('O')
                privateHandler = true
            }
        }
        for (i in 0..2) {
            if (gameField[i][0] === 'O' && gameField[i][1] === 'O' && gameField[i][2] === 'O') {
                showWinner('O')
                privateHandler = true
            }
        }
        if (gameField[2][0] === 'O' && gameField[1][1] === 'O' && gameField[0][2] === 'O' ||
            gameField[0][0] === 'O' && gameField[1][1] === 'O' && gameField[2][2] === 'O'
        ) {
            showWinner('O')
            privateHandler = true
        }

        if (!privateHandler && handler == 9.toByte()) {
            showWinner('E')
        }
    }

    private fun showWinner(winner: Char) {
        val gameView = findViewById<TextView>(R.id.gameView)
        val resources = this.resources

        when(winner) {
            'X' -> { gameView.text = resources.getString(R.string.winner_x)}
            'O' -> { gameView.text = resources.getString(R.string.winner_o)}
            'E' -> { gameView.text = resources.getString(R.string.winner_xo)}
        }
        deactivateAllOnclicklistener()
    }

    private fun updateGamefield(button: Byte, player: Char) {
        val newGame = findViewById<ImageButton>(R.id.newGame)
        when (button) {
            1.toByte() -> {gameField[0][0] = player}
            2.toByte() -> {gameField[1][0] = player}
            3.toByte() -> {gameField[2][0] = player}
            4.toByte() -> {gameField[0][1] = player}
            5.toByte() -> {gameField[1][1] = player}
            6.toByte() -> {gameField[2][1] = player}
            7.toByte() -> {gameField[0][2] = player}
            8.toByte() -> {gameField[1][2] = player}
            9.toByte() -> {gameField[2][2] = player}
        }
        handler = handler.plus(1).toByte()
        newGame.visibility = View.VISIBLE
    }

    private fun deactivateAllOnclicklistener() {
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)
        val button5 = findViewById<Button>(R.id.button5)
        val button6 = findViewById<Button>(R.id.button6)
        val button7 = findViewById<Button>(R.id.button7)
        val button8 = findViewById<Button>(R.id.button8)
        val button9 = findViewById<Button>(R.id.button9)

        button1.setOnClickListener(null)
        button2.setOnClickListener(null)
        button3.setOnClickListener(null)
        button4.setOnClickListener(null)
        button5.setOnClickListener(null)
        button6.setOnClickListener(null)
        button7.setOnClickListener(null)
        button8.setOnClickListener(null)
        button9.setOnClickListener(null)
    }
}