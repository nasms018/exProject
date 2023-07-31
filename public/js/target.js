class Target {
	//크기 위치
	constructor(imgTarget, posX, posY, width, height) {
		this.imgTarget = imgTarget;
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
	}
	draw(ctx){
		ctx.drawImage(this.imgTarget, this.posX, this.posY, this.width, this.height);
	}
	
	inXBound(ballX) {
		return (ballX >= this.posX) && (ballX <= this.posX + this.width);
		
		}
	inYBound(ballY) {
		return (ballY >= this.posY) && (ballY <= this.posY + this.height);
		
		}
	
}