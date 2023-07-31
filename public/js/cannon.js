class Cannon {
	//크기 위치
	constructor(posX, posY) {

		this.posX = posX;	
		this.posY = posY;
	
		
	}
	위치지정(posX, posY) {
		this.posX = posX;	//공의 위치
		this.posY = posY;
	
	}
	장전(ball) {
		this.ball = ball;
		this.ball.위치지정(this.posX, this.posY);
	}
	발사(velocity, angle) {
		// 360>> PI
            var angleR = angle * Math.PI / 180;
			//vector 분석
            var ballVx = velocity * Math.cos(angleR);
            var ballVy = -velocity * Math.sin(angleR);
            
            this.ball.발사(ballVx, ballVy);
            
    }





}

//let user = new User("John");
//user.sayHi();