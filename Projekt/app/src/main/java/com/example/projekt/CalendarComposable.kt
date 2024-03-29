    package com.example.projekt


    import androidx.compose.foundation.background
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.aspectRatio
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.material3.Button
    import androidx.compose.material3.Text
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.unit.sp
    import androidx.navigation.NavHostController
    import com.kizitonwose.calendar.compose.HorizontalCalendar
    import com.kizitonwose.calendar.compose.rememberCalendarState
    import com.kizitonwose.calendar.core.CalendarDay
    import com.kizitonwose.calendar.core.daysOfWeek
    import java.time.DayOfWeek
    import java.time.YearMonth

    @Composable
    fun CalendarComposable(navController: NavHostController) {


        var currentMonth by remember { mutableStateOf(YearMonth.now()) }
        val startMonth = remember { currentMonth.minusMonths(100) } // Adjust as needed
        val endMonth = remember { currentMonth.plusMonths(100) } // Adjust as needed

        val daysOfWeek = daysOfWeek(firstDayOfWeek = DayOfWeek.MONDAY)

        val state = rememberCalendarState(
            startMonth = startMonth,
            endMonth = endMonth,
            firstVisibleMonth = currentMonth,
            firstDayOfWeek = daysOfWeek.first()

        )

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            Row{//this row will contain current month and buttons to change "currentMonth" forward and backwards

                Button(onClick = {
                    currentMonth = currentMonth.minusMonths(1)

                }) {
                    Text("<-",fontSize = 20.sp)

                    LaunchedEffect(currentMonth) {
                        state.animateScrollToMonth(currentMonth)
                    }

                }

                Text(text = currentMonth.toString(),fontSize = 30.sp)

                Button(onClick = {
                    currentMonth = currentMonth.plusMonths(1)
                }) {
                    Text("->",fontSize = 20.sp)
                    LaunchedEffect(currentMonth) {
                        state.animateScrollToMonth(currentMonth)
                    }
                }
            }

            HorizontalCalendar(
                state = state,
                dayContent = { Day(it) }

            )
            Row {
                Text(text = "Today you ate XXXX calories",fontSize = 16.sp)
            }
            Button(onClick = {
                navController.navigate("todaysMeal")
                })
                {
                    Text(text = "Todays meals",fontSize = 16.sp)
                }
            Spacer(modifier = Modifier.weight(1.0f))
            Button(
                onClick = {
                    println("hehe2")
                }
                ) {
                    Text(text = "settings",fontSize = 16.sp)
                }
        }


    }



    @Composable
    fun Day(day: CalendarDay) {


        // tutaj mogę zrobić coś w tym stylu że zielone tło jak cel został osiągnięty, żółte jak niedobur/nadmiar o 300 kalorii/dowolnej ilości i czerwony jak ktoś przekroczy ten próg wcześniejszy
        val isOdd = day.date.dayOfMonth % 2 != 0

        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .clickable {
                    // Handle the click event here
                    println("test: ${day.date.dayOfMonth} , ${day.date.month} , ${day.date.year}")
                }
                .background(if (isOdd) Color.Red else Color.Green)
                , // This is important for square sizing!
            contentAlignment = Alignment.Center
        ) {
            Text(text = day.date.dayOfMonth.toString())
        }
    }




