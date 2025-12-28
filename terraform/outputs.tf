output "ecr_url" {
  value = aws_ecr_repository.app_repo.repository_url
}

output "ec2_public_ip" {
  description = "Public IP address of the EC2 instance"
  value = aws_instance.app_ec2.public_ip
}