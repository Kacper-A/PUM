    package com.example.projekt_proba2


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
    import com.example.projekt_proba2.data.ItemViewModel
    import com.kizitonwose.calendar.compose.HorizontalCalendar
    import com.kizitonwose.calendar.compose.rememberCalendarState
    import com.kizitonwose.calendar.core.CalendarDay
    import com.kizitonwose.calendar.core.daysOfWeek
    import java.time.DayOfWeek
    import java.time.LocalDate
    import java.time.YearMonth
    import java.time.ZoneOffset

    @Composable
    fun CalendarComposable(viewModel: ItemViewModel, navController: NavHostController) {


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

        var limit = remember{viewModel.getItemFromDateDirectly(2137).brekafast}


        var MaxOrMin = remember{

            viewModel.getItemFromDateDirectly(2137).lunch != 0


        }




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
                dayContent = { Day(it,viewModel,navController,limit.toInt(),MaxOrMin) }

            )
            Row {
                var todayItem = viewModel.getItemFromDateDirectly(LocalDate.now().atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli())
                var sum =0
                if(todayItem!=null)
                {
                    sum = todayItem.brekafast+todayItem.lunch+todayItem.dinner
                }


                Text(text = "Today you ate "+sum+" calories",fontSize = 16.sp)
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
                    navController.navigate("settings")
                }
                ) {
                    Text(text = "settings",fontSize = 16.sp)
                }
        }


    }



    @Composable
    fun Day(day: CalendarDay,viewModel: ItemViewModel, navController: NavHostController,limit: Int,mode: Boolean) {


        // tutaj mogę zrobić coś w tym stylu że zielone tło jak cel został osiągnięty, żółte jak niedobur/nadmiar o 300 kalorii/dowolnej ilości i czerwony jak ktoś przekroczy ten próg wcześniejszy
        val isOdd = day.date.dayOfMonth % 2 != 0
        var itemInGivenDate = viewModel.getItemFromDateDirectly(day.date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli())
        Box(

            modifier = Modifier
                .aspectRatio(1f)
                .clickable {
                    // Handle the click event here
                    println("test: ${day.date.dayOfMonth} , ${day.date.month} , ${day.date.year}")
                    println("calendar click timestamp: ${day.date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()}")
                    navController.navigate("specificDay/${day.date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()}")
                }
                .background(
                    if (itemInGivenDate!= null)
                {
                        var sum = 0
                    sum = itemInGivenDate.lunch + itemInGivenDate.brekafast + itemInGivenDate.dinner
                    if(sum >limit)
                    {
                        if(mode == false)
                        {
                            Color.Red
                        }
                        else
                        {
                            Color.Green
                        }

                    }
                    else
                    {
                        if(mode == false)
                        {
                            Color.Green
                        }
                        else
                        {
                            Color.Red
                        }

                    }

                }
                else
                {
                    Color.Gray
                })
                , // This is important for square sizing!
            contentAlignment = Alignment.Center
        ) {
            Text(text = day.date.dayOfMonth.toString())
        }
    }




