package com.kuit.kuit5.ui.shopping.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kuit.kuit5.R
import com.kuit.kuit5.ui.shopping.components.ShoppingAccountDetail
import com.kuit.kuit5.ui.shopping.components.ShoppingGrayButton
import com.kuit.kuit5.ui.shopping.viewmodel.ShoppingViewModel
import com.kuit.kuit5.ui.theme.BankSaladTheme.colors
import com.kuit.kuit5.ui.theme.BankSaladTheme.typography

@Composable
fun ProductInfoScreen(
    modifier: Modifier = Modifier,
    viewModel: ShoppingViewModel,
    onNavigateToCreateAccount: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(colors.white)
    ) {
        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Image(
                painter = painterResource(viewModel.KBShoppingProduct.icon),
                contentDescription = "KB img",
                modifier = Modifier
                    .size(320.dp, 145.dp)
            )
            Spacer(modifier = Modifier.size(30.dp))
            Column(verticalArrangement = Arrangement.spacedBy(30.dp)) {
                Text(text = viewModel.KBShoppingProduct.name, style = typography.head_02_B_20)
                ShoppingAccountDetail(question = "가입 연령", answer = viewModel.KBShoppingProduct.age)
                ShoppingAccountDetail(question = "소득 기준", answer = viewModel.KBShoppingProduct.earnings)
                ShoppingAccountDetail(question = "월 납입 금액", answer = viewModel.KBShoppingProduct.payment)
                ShoppingAccountDetail(question = "정부 지원금", answer = viewModel.KBShoppingProduct.govern)
            }
        }
        Box(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).padding(20.dp)) {
            ShoppingGrayButton(
                modifier = Modifier.padding(top = 167.dp),
                "가입하기",
                onClick = { onNavigateToCreateAccount() }
            )
        }
    }


//    Column {
//        Button(
//            onClick = {
//                onNavigateToCreateAccount()
//            }
//        ) {
//            Text(text = "ProductInfoScreen")
//        }
//        Text(text = "${viewModel.newAccount.value}")
//    }
}

@Preview(showBackground = true)
@Composable
private fun ProductInfoScreenPreview() {
    ProductInfoScreen(
        viewModel = viewModel()
    ) { }
}