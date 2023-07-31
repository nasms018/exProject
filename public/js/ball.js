class Ball {
	//크기 위치
	constructor(radius) {

		this.radius = radius;// 공의 반지름
		this.posX = 0;	//공의 위치
		this.posY = 0;
		this.vX = 0;	//공의 속도
		this.vY = 0;

	}
	위치지정(posX, posY) {
		this.posX = posX;	//공의 위치
		this.posY = posY;
	}
	
	발사(ballVx, ballVy) {
		this.vX = ballVx;	//공의 속도
		this.vY = ballVy;
	}
	그리기간격(timeInterVal) {
		this.timeInterVal = timeInterVal;
	}
	시간경과() {
		
			//수평 등속 운동
            this.posX += this.vX;
            this.posY += this.vY;
	}
	맞추었니(target) {
		return target.inXBound(this.posX) 
		&& target.inYBound(this.posY);
		//(this.posX > 60 && this.posY <=210);
		}
	/* 공을 화면에 그린다. */
	drawBall(stx) {
		stx.beginPath();
		stx.arc(this.posX, this.posY, this.radius, 0, 2.0 * Math.PI, true);
		stx.fillStyle = "darkred";
		stx.fill();
	}

}

//let user = new User("John");
//user.sayHi();