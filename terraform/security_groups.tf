resource "aws_security_group" "ec2_sg" {
  name = "ec2-sg"

  egress {
    from_port   = 27017
    to_port     = 27017
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # Replace with MongoDB IP
  }

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["136.185.168.142/32"]
  }
}