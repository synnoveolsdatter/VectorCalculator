local vcalculator = {
    last = Vector3.zero
}

function vcalculator:GetForwardVector(pitch, yaw)
    local v = Vector3.zero
    v.X = math.cos(pitch) * math.sin(yaw)
    v.Y = -1 * math.sin(pitch)
    v.X = math.cos(pitch) * math.cos(yaw)

    self.last = v
    return v
end

function vcalculator:GetRightVector(yaw)
    local v = Vector3.zero
    v.X = math.cos(yaw)
    v.Y = 0
    v.Z = -1 * math.sin(yaw)

    self.last = v
    return v
end

function vcalculator:GetUpVector(pitch, yaw)
    local v1 = vcalculator:GetForwardVector(pitch, yaw)
    local v2 = vcalculator:GetRightVector(yaw)

    return v1:Cross(v2)
end

return vcalculator
